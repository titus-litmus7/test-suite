<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

    <!-- Calculates the minimum value of a sequence of numbers. -->
    <xsl:template name="min">
        <xsl:param name="seq"/>
        <xsl:param name="minSoFar"/>
        <xsl:choose>
            <xsl:when test="$seq">
                <xsl:variable name="min">
                    <xsl:choose>
                        <xsl:when test="string-length($minSoFar) = 0 or $seq[1] &lt; $minSoFar">
                            <xsl:value-of select="$seq[1]"/>
                        </xsl:when>
                        <xsl:otherwise>
                            <xsl:value-of select="$minSoFar"/>
                        </xsl:otherwise>
                    </xsl:choose>
                </xsl:variable>
                <xsl:call-template name="min">
                    <xsl:with-param name="seq" select="$seq[position()!=1]"/>
                    <xsl:with-param name="minSoFar" select="$min"/>
                </xsl:call-template>
            </xsl:when>
            <xsl:otherwise>
                <xsl:value-of select="$minSoFar"/>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:template>

</xsl:stylesheet>