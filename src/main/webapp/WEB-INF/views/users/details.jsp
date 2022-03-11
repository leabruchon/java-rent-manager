<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
        <!-- Main content -->
        <section class="content">

            <div class="row">
                <div class="col-md-3">

                    <!-- Profile Image -->
                    <div class="box box-primary">
                        <div class="box-body box-profile">
                            <h3 class="profile-username text-center">${user.prenom} ${user.nom} (${user.email})</h3>

                            <ul class="list-group list-group-unbordered">
                                <li class="list-group-item">
                                    <b>${user.naissance}</b> <a class="pull-right"></a>
                                </li>
                                
                            </ul>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
                <!-- /.col -->
                <div class="col-md-9">
                    <div class="nav-tabs-custom">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#rents" data-toggle="tab">Reservations</a></li>
                           
                        </ul>
                        <div class="tab-content">
                            <div class="active tab-pane" id="rents">
                                <div class="box-body no-padding">
                                    <table class="table table-striped">
                                        <tr>
                                            <th style="width: 10px">#</th>
                                            <th>Voiture</th>
                                            <th>Date de debut</th>
                                            <th>Date de fin</th>
                                        </tr>
                                        <c:forEach  var="rent" items="${rents}">
                                             <tr>
                                                <td>${rent.id}.</td>
                                                <td>${rent.vehicule_id}</td>
                                                <td>${rent.debut}</td>
                                                <td>${rent.fin}</td> 
                                            </tr>
                                        </c:forEach>  
                                    </table>
                                </div>
                            </div>

                            
                            <!-- /.tab-pane -->
                            <div class="tab-pane" id="cars">
                                <!-- /.box-header -->
                                <!--
                                <div class="box-body no-padding">
                                    <table class="table table-striped">
                                        <tr>
                                            <th style="width: 10px">#</th>
                                            <th>Modele</th>
                                            <th>Constructeur</th>
                                            <th style=>Nombre de places</th>
                                        </tr>
                                        <tr>
                                            <td>1.</td>
                                            <td>Renault</td>
                                            <td>Clio</td>
                                            <td>5</td>
                                        </tr>
                                        <tr>
                                            <td>2.</td>
                                            <td>Peugeot</td>
                                            <td>206</td>
                                            <td>5</td>
                                        </tr>
                                        <tr>
                                            <td>3.</td>
                                            <td>Volkswagen</td>
                                            <td>Touran</td>
                                            <td>7</td>
                                        </tr>
                                    </table>
                                </div>
                            </div> 
                            <!-- /.tab-pane -->
                        </div>
                        <!-- /.tab-content -->
                    </div>
                    <!-- /.nav-tabs-custom -->
                </div>
                <!-- /.col -->
            </div>
            <!-- /.row -->

        </section>
        <!-- /.content -->
    </div>

    <%@ include file="/WEB-INF/views/common/footer.jsp" %>
</div>
<!-- ./wrapper -->

<%@ include file="/WEB-INF/views/common/js_imports.jsp" %>
</body>
</html>
