<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

	<xsl:template name="header">
		<xsl:param name="title" select="'Load and Performance Test Report'"/>
		<xsl:param name="productName" select="/testreport/configuration/version/productName"/>
		<xsl:param name="productVersion" select="/testreport/configuration/version/version"/>
		<xsl:param name="productUrl" select="/testreport/configuration/version/productURL"/>

		<xsl:call-template name="navigation">
			<xsl:with-param name="current" select="general"/>
		</xsl:call-template>

		<div id="header">
			<img src="images/logo.png" class="logo" alt="The company logo"/>
			<h1>
				<xsl:value-of select="$title"/>
			</h1>
			<h2>
				Created with
				<a href="{$productUrl}?piwik_campaign=TestReport">
					<span class="productname">
						<xsl:value-of select="$productName"/>
					</span>
					<span class="productversion">
						<xsl:value-of select="$productVersion"/>
					</span>
				</a>
			</h2>
		</div>

	</xsl:template>

</xsl:stylesheet>
