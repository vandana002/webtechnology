<?xml version = "1.0" encoding = "UTF-8"?>
<xsl:stylesheet version = "1.0"
xmlns:xsl = "http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html>
<body>
<h2>Teaching</h2>
 <table border = "1">
 <tr bgcolor = "#9acd32">
 <th>College</th>
 <th>Name</th>
 <th>ID</th>
 <th>Dept.</th>
 </tr>
 <xsl:for-each select="gvp/teaching">
 <tr>
 <td>
 <xsl:value-of select="@clg"/>
 </td>
 <td><xsl:value-of select="name"/></td>
 <td><xsl:value-of select="id"/></td>
 <td><xsl:value-of select="dept"/></td>
 </tr>
 </xsl:for-each>
 </table>
 <h2>Non-Teaching</h2>
 <table border = "1">
 <tr bgcolor = "#9acd32">
 <th>College</th>
 <th>Name</th>
 <th>ID</th>
 </tr>
 <xsl:for-each select="gvp/non_teaching">
 <tr>
 <td>
 <xsl:value-of select="@clg"/>
 </td>
 <td><xsl:value-of select="name"/></td>
 <td><xsl:value-of select="id"/></td>
 </tr>
 </xsl:for-each>
 </table>
 <h2>Student</h2>
 <table border = "1">
 <tr bgcolor = "#9acd32">
 <th>College</th>
 <th>Name</th>
 <th>Roll No.</th>
 <th>Dept.</th>
 </tr>
 <xsl:for-each select="gvp/student">
 <tr>
 <td>
 <xsl:value-of select="@clg"/>
 </td>
 <td><xsl:value-of select="name"/></td>
 <td><xsl:value-of select="rollno"/></td>
 <td><xsl:value-of select="dept"/></td>
 </tr>
 </xsl:for-each>
 </table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>
