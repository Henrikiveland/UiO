<?xml version="1.0"?>
<xsl:stylesheet
    version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns="http://www.w3.org/1999/xhtml">
        <xsl:output method="xml" indent="yes" encoding="UTF-8"/>

        <xsl:template match="/result">
            <html>

                <head>
                    <title> Question 2</title>

                    <style>
                        table {
                            border-style:solid;
                            border-width:1px;
                            border-color:gray;
                            padding:4px;
                        }

                        td {
                            border-style:dotted;
                            border-width:1px;
                            border-color:gray;
                            padding:2px;
                        }

                        .firstCol {
                            color:gray;
                            font-size:15px;
                        }

                        .secCol {
                            color:red;
                            font-size:20px;
                        }
                    
                    </style>
                </head>

                <body>
                    <h1>Exam result</h1>
                    <table>
                        <tr>
                            <td class="firstCol">Reference number</td>
                            <td class="secCol"><xsl:value-of select="@ref" /></td>
                        </tr>
                        
                        <tr>
                            <td class="firstCol">Exam number</td>
                            <td class="secCol"><xsl:value-of select="examId" /></td>
                        </tr>

                        <tr>
                            <td class="firstCol">Contestant number</td>
                            <td class="secCol"><xsl:value-of select="contestantId" /></td>
                        </tr>

                        <tr>
                            <td class="firstCol">Digital signature</td>
                            <td class="secCol"><xsl:value-of select="digitalSignature" /></td>
                        </tr>

                        <tr>
                            <td class="firstCol">Score</td>
                            <td class="secCol"><xsl:value-of select="score" /></td>
                        </tr>

                        <tr>
                            <td class="firstCol">Band</td>
                            <td class="secCol"><xsl:value-of select="band" /></td>
                        </tr>

                    </table>
                </body>

            </html>
        </xsl:template>
</xsl:stylesheet>