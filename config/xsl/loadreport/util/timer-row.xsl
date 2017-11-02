<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

    <xsl:template name="timer-row">
        <xsl:param name="type"/>

        <xsl:variable name="gid" select="generate-id(.)"/>

        <tr>
            <!-- name -->
            <td class="key colgroup1 forcewordbreak">
                <a>
                    <xsl:attribute name="href">#chart-<xsl:value-of select="$gid"/></xsl:attribute>
                    <xsl:attribute name="data-id">tableEntry-<xsl:value-of select="$gid"/></xsl:attribute>
                    <xsl:if test="count(urls) &gt; 0">
                        <!-- title and class only for requests with urls -->
                        <xsl:attribute name="data-rel">#url-listing-<xsl:value-of select="$gid"/></xsl:attribute>
                        <xsl:attribute name="class">cluetip</xsl:attribute>
                    </xsl:if>
                    <xsl:value-of select="name"/>
                </a>
                <xsl:text></xsl:text>
                <xsl:if test="count(urls) &gt; 0">
                    <div id="url-listing-{$gid}" class="cluetip-data">
                        <h4>
                            <xsl:value-of select="urls/total"/>
                            <xsl:text> unique URL(s)</xsl:text>
                        </h4>
                        <ul class="urls">
                            <xsl:for-each select="urls/list/string">
                                <xsl:variable name="oddoreven">
                                    <xsl:choose>
                                        <xsl:when test="position() mod 2 = 0">
                                            <xsl:text>even</xsl:text>
                                        </xsl:when>
                                        <xsl:otherwise>
                                            <xsl:text>odd</xsl:text>
                                        </xsl:otherwise>
                                    </xsl:choose>
                                </xsl:variable>
                                <li class="{$oddoreven}">
                                    <a href="{.}" target="_blank">
                                        <xsl:value-of select="."/>
                                    </a>
                                </li>
                            </xsl:for-each>
                        </ul>
                    </div>
                </xsl:if>
            </td>

            <!-- count -->
            <td class="value number">
                <xsl:value-of select="format-number(count, '#,##0')"/>
            </td>

            <!-- count per sec -->
            <td class="value number">
                <xsl:value-of select="format-number(countPerSecond, '#,##0.0')"/>
            </td>

            <!-- count per hour -->
            <td class="value number">
                <xsl:value-of select="format-number(countPerHour, '#,##0')"/>
            </td>

            <!-- count per day -->
            <td class="value number">
                <xsl:value-of select="format-number(countPerDay, '#,##0')"/>
            </td>

            <!-- errors -->
            <td class="value number colgroup1">
                <xsl:if test="errors &gt; 0">
                    <xsl:attribute name="class">value number colgroup1 error</xsl:attribute>
                </xsl:if>
                <xsl:value-of select="format-number(errors, '#,##0')"/>
            </td>

            <!-- % errors -->
            <xsl:variable name="error-percentage">
                <xsl:call-template name="percentage">
                    <xsl:with-param name="n1" select="count"/>
                    <xsl:with-param name="n2" select="errors"/>
                </xsl:call-template>
            </xsl:variable>
            <td class="value number colgroup1">
                <xsl:if test="errors &gt; 0">
                    <xsl:attribute name="class">value number colgroup1 error</xsl:attribute>
                </xsl:if>
                <xsl:value-of select="format-number($error-percentage, '#,##0.00')"/>
                <xsl:text>%</xsl:text>
            </td>

            <!-- events -->
            <xsl:if test="$type = 'transaction'">
                <td class="value number colgroup1">
                    <xsl:if test="events &gt; 0">
                        <xsl:attribute name="class">value number colgroup1 event</xsl:attribute>
                    </xsl:if>
                    <xsl:value-of select="format-number(events, '#,##0')"/>
                </td>
            </xsl:if>

            <!-- mean -->
            <td class="value number">
                <xsl:value-of select="format-number(mean, '#,##0')"/>
            </td>

            <!-- min -->
            <td class="value number">
                <xsl:value-of select="format-number(min, '#,##0')"/>
            </td>

            <!-- max -->
            <td class="value number">
                <xsl:value-of select="format-number(max, '#,##0')"/>
            </td>

            <!-- deviation -->
            <td class="value number">
                <xsl:value-of select="format-number(deviation, '#,##0')"/>
            </td>

            <!-- runtime percentiles -->
            <xsl:for-each select="percentiles/*">
                <td class="value number colgroup1">
                    <xsl:value-of select="format-number(current(), '#,##0')"/>
                </td>
            </xsl:for-each>

            <!-- runtime segmentation -->
            <xsl:if test="$type = 'request'">
                <xsl:for-each select="countPerInterval/int">
                    <td class="value number">
                        <xsl:variable name="percentage">
                            <xsl:call-template name="percentage">
                                <xsl:with-param name="n1" select="../../count"/>
                                <xsl:with-param name="n2" select="current()"/>
                            </xsl:call-template>
                        </xsl:variable>
                        <span>
                            <xsl:attribute name="title">
                                <xsl:value-of select="format-number(current(), '#,##0')"/>
                                <xsl:text> (</xsl:text>
                                <xsl:value-of select="format-number($percentage, '#,##0.00')"/>
                                <xsl:text>%)</xsl:text>
                            </xsl:attribute>
                            <xsl:value-of select="format-number($percentage, '#,##0.00')"/>
                            <xsl:text>%</xsl:text>
                        </span>
                    </td>
                </xsl:for-each>
            </xsl:if>
        </tr>

    </xsl:template>

</xsl:stylesheet>