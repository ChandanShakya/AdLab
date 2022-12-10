<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <title>Oceans</title>
            </head>
            <style>
                fieldset {
                background-color: white;
                }

                legend {
                background-color:  #ccddff;
                color: black;
                padding: 5px 10px;
                }
            </style>
            <body>
                <fieldset>
                    <legend>Oceans</legend>
                    <xsl:for-each select="oceans/ocean">
                        <b><xsl:value-of select="name"/></b><br/>
                        Area: <xsl:value-of select="area"/><br/>
                        Mean Depth: <xsl:value-of select="meanDepth"/><br/><br/>
                    </xsl:for-each>
                </fieldset>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>


<!--
    XSL file to transform the XML file into HTML
-->

