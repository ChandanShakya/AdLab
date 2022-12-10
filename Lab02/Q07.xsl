<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h1>List of class students</h1>
                <ul>
                    <xsl:for-each select="Students/Student">
                        <li>
                            Name: <xsl:value-of select="Name"/>, 
                            Address: <xsl:value-of select="Address"/>, 
                            Roll no: <xsl:value-of select="RollNo"/>, 
                            Batch: <xsl:value-of select="BatchNo"/>
                        </li>
                    </xsl:for-each>
                </ul>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
<!-- XSL for the XML file -->

