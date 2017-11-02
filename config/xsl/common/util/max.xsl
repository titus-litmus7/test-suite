<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

    <!-- Calculates the maximum value of a sequence of numbers. -->
    <xsl:template name="max">
        <xsl:param name="seq"/>
        <xsl:param name="maxSoFar"/>
        <xsl:choose>
            <xsl:when test="$seq">
                <xsl:variable name="max">
                    <xsl:choose>
                        <xsl:when test="string-length($maxSoFar) = 0 or $seq[1] &gt; $maxSoFar">
                            <xsl:value-of select="$seq[1]"/>
                        </xsl:when>
                        <xsl:otherwise>
                            <xsl:value-of select="$maxSoFar"/>
                        </xsl:otherwise>
                    </xsl:choose>
                </xsl:variable>
                <xsl:call-template name="max">
                    <xsl:with-param name="seq" select="$seq[position()!=1]"/>
                    <xsl:with-param name="maxSoFar" select="$max"/>
                </xsl:call-template>
            </xsl:when>
            <xsl:otherwise>
                <xsl:value-of select="$maxSoFar"/>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:template>

</xsl:stylesheet>