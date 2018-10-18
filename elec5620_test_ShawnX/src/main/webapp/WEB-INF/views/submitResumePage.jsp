<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
    <p><a href="http://localhost:8080/sydney/JobPostHome">Job Post</a>
    <a href="http://localhost:8080/sydney/ResumeCentre">Resume Centre</a>
    <a href="http://localhost:8080/sydney/JobCentre">Jobs Centre</a>
    </p>
    </head>
    <body>
        <h3>Welcome, Enter Your Personal Information</h3>
        <h3>Welcome, Enter Your Personal Information</h3>
        <h3>Welcome, Enter Your Personal Information</h3>
        <form id="saveForm" action="saveResume" method="post">
        <table style="font-size: :16px">
        <tr>
                <td>JobPost Id</td>
                <td><input type="text" value="${model}" name="JobPostId" /></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" value="${Resume.name }" name="name" /></td>
            </tr>
            <tr>
                <td>Age</td>
                <td><input type="text" value="${Resume.age }" name="age" /></td>
            </tr>
            <tr>
            <td><input type="submit" value="Submit"/></td>
                    <td><input type="reset" value="Reset"/></td></tr>
        </table>
        </form>
        
        
        
    </body>
</html>



<%-- <form:form method="POST"
          action="/sydney/addResume" modelAttribute="resume">
             <table>
             	<tr>
                    <td><form:label path="name">Name</form:label></td>
                    <td><form:input path="name" value="name"/></td>
                </tr>
                <tr>
                    <td><form:label path="age">Age</form:label></td>
                    <td><form:input path="age" value="age"/></td>
                </tr>
                <tr>
                    <td><form:label path="location">Location</form:label></td>
                    <td><form:input path="location" value="location"/></td>
                </tr>
                <tr>
                    <td><form:label path="company">Company</form:label></td>
                    <td><form:input path="company" /></td>
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
        </form:form> --%>