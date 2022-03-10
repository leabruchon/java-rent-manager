<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@page pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<%@include file="/WEB-INF/views/common/head.jsp"%>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <%@ include file="/WEB-INF/views/common/header.jsp" %>
    <!-- Left side column. contains the logo and sidebar -->
    <%@ include file="/WEB-INF/views/common/sidebar.jsp" %>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                Voitures
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/cars/create">Ajouter</a>
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <div class="box">
                        <div class="box-body no-padding">
                            <table class="table table-striped">
                                <tr>
                                    <th style="width: 10px">#</th>
                                    <!--<th>Propriétaire</th>-->
                                    <th>Constructeur</th>
                                    <!--<th>Modèle</th>-->
                                    <th>Nombre de places</th>
                                    <th>Action</th>
                                </tr>
                               

                                <c:forEach  var="vehicle" items="${cars}">
                                    <tr>
                                        <td>${vehicle.id}</td>
                                        <!--<td>1</td>-->
                                        <td>${vehicle.constructeur}</td>
                                        <!--<td>Picanto</td>-->
                                        <td>${vehicle.nb_place}</td>
                                        <td style = "display: flex; flex-direction: row;">
                                              
                                            <!--
                                            <form class="form-horizontal" method="POST" action="./users/update" style = "padding: 2px">
                                                <button type = "submit" class="btn btn-success enabled" >
                                                    <input type="hidden" id="id" name="id" value="${user.id}">
                                                    <i class="fa fa-edit"></i>
                                                </button>
                                            </form> -->

                                            <form class="form-horizontal" method="POST" action="./cars" style = "padding: 2px">
                                                <button type = "submit" class="btn btn-danger enabled">
                                                    <input type="hidden" id="id" name="id" value="${vehicle.id}">
                                                    <i class="fa fa-trash"></i>
                                                </button>
                                            </form>
                                            
                                        </td> 
                                        </td> 
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
                <!-- /.col -->
            </div>
        </section>
        <!-- /.content -->
    </div>

    <%@ include file="/WEB-INF/views/common/footer.jsp" %>
</div>
<!-- ./wrapper -->

<%@ include file="/WEB-INF/views/common/js_imports.jsp" %>
</body>
</html>
