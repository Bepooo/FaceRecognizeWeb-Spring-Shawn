<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
    </head>
    <body>
        <h3>Welcome, Enter The Employee Details</h3>
        <form:form method="POST"
          action="/sydney/addJobPost" modelAttribute="jobpost">
             <table>
                <tr>
                    <td><form:label path="location">Location</form:label></td>
                    <td><form:input path="location"/></td>
                </tr>
                <tr>
                    <td><form:label path="company">Company</form:label></td>
                    <td><form:input path="company"/></td>
                </tr>
                <tr>
                    <td><form:label path="department">Department</form:label></td>
                    <td><form:input path="department"/></td>
                </tr>
                <tr>
                    <td><form:label path="position">Position</form:label></td>
                    <td><form:input path="position"/></td>
                </tr>
                <tr>
                    <td><form:label path="employmenttype">Employment Type</form:label></td>
                    <td><form:input path="employmenttype"/></td>
                </tr>
                <tr>
                    <td><form:label path="jobdescription">
                      Job Description</form:label></td>
                    <td><form:input path="jobdescription"/></td>
                </tr>
                <tr>
                    <td><form:label path="requirements">
                      Requirements</form:label></td>
                    <td><form:input path="requirements"/></td>
                </tr>
                
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                    <td><input type="reset" value="Reset"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>