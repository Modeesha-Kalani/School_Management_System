<!-- Interface of the page -->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

   <meta charset="ISO-8859-1">
<title>Add Student</title>
<!-- Custom fonts for this template-->
        <link href="../../vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="../../css/sb-admin-2.min.css" rel="stylesheet">
    </head>

    <body id="page-top">

        <!-- Page Wrapper -->
        <div id="wrapper">
        
        
        
        <div class="modal fade" id="ModalSport" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="form-horizontal">
            <div class="modal-header">
              <h4 class="modal-title" id="myModalLabel">Selected Association Details</h4>
            </div>

            <div class="modal-body">
			<input type=text id="hidden_id" hidden>
              <div class="form-group">
                <label for="title" class="col-sm-5 control-label">Association Name</label>
                <div class="col-sm-10">
                  <input type="text"  class="form-control" id="a_name" placeholder="Enter Sport Name">
                </div>
              </div>



              <div class="form-group">
                <label for="title" class="col-sm-5 control-label">Member Count</label>
                <div class="col-sm-10">
                  <input type="number" class="form-control" id="mem_count_update" value="">
                </div>
              </div>

            </div>

            <div class="modal-footer">
              <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
              <button type="submit" id="update_sport_details" onclick="update_asso()" class="btn btn-primary">Update Association Details</button>
            </div>

          </div>
        </div>
      </div>
    </div>
        

             <!-- Page Wrapper -->
        <!-- Sidebar -->
            <jsp:include page="../common/sidebar.jsp" />
            
            <!-- End of Sidebar -->

            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content">

                    <!-- Topbar -->
                    <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
     
						<div class="row">
						<div class="col-12" style="width:100%"></div>
							<h3 class="text-center">Kanampella Central College</h3>
						</div>
						
                        <!-- Sidebar Toggle (Topbar) -->
                        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                            <i class="fa fa-bars"></i>
                        </button>




                        <!-- Topbar Navbar -->
                        <ul class="navbar-nav ml-auto">

                            <div class="topbar-divider d-none d-sm-block"></div>

                            <!-- Nav Item - User Information -->
                            <li class="nav-item dropdown no-arrow">
                                
                                <!-- Dropdown - User Information -->
                                <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">

                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                        <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Logout
                                    </a>
                                </div>
                            </li>

                        </ul>

                    </nav>
                    <!-- End of Topbar -->

                    <div class="container-fluid">

                        <h1 class="h3 mb-4 text-gray-800">Add Association Details</h1>

                        <form class="user" id="association_frm">
                            <div class="form-group" id="association">
                                <label>Association Name</label>
                                <input type="text" class="form-control form-control-user" id="asso_name" placeholder="Association Name">
                            </div>

                            <div class="form-group">
                                <label>Select Teacher</label>
                                <select class="form-control select2" id="teacher">
                                    
                                </select>
                            </div>

                           <div class="form-group">
                                <label>Member Count</label>
                                <input type="number" class="form-control form-control-user" id="count" min="1" value="1" placeholder="Member Count">
                            </div>

                            
                            <br><br>
                            <input type="submit" name="submitAssorciations" onclick="validateSubmit(event)" class="btn btn-success btn-user btn-block" value="Save Association Details">
                            <hr>
                        </form>


                    </div>
                    <!-- /.container-fluid -->
					<div class="container-fluid">

					<h1 class="h3 mb-4 text-gray-800">Manage Association Details</h1>

					<div class="card-body">
						<div class="table-responsive">
							<table class="table text-nowrap" id="tblViewStudents">
								<thead>
									<tr>
										<th>Association Name</th>
										<th>Teacher Name</th>
										<th>Member Count</th>
										<th>Update</th>
										<th>Delete</th>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>

						</div>
					</div>


                </div>
                <!-- End of Main Content -->

                <!-- Footer -->
                <footer class="sticky-footer bg-white">
                    <div class="container my-auto">

                    </div>
                </footer>
                <!-- End of Footer -->

            </div>
            <!-- End of Content Wrapper -->

        </div>
        <!-- End of Page Wrapper -->

        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>

        <!-- Logout Modal-->
        <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                    </div>
                    <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                    <div class="modal-footer">
                        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                        <a class="btn btn-primary" href="login.html">Logout</a>
                    </div>
                </div>
            </div>
        </div>

        <!-- Bootstrap core JavaScript-->
        <script src="../../vendor/jquery/jquery.min.js"></script>
        <script src="../../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="../../vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="../../js/sb-admin-2.min.js"></script>
        <script src="../../plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="../../plugins/select2/js/select2.full.min.js"></script>
        <script>
            $(function () {
                $('.select2').select2();
                $('.select2bs4').select2({
                    theme: 'bootstrap4'
                });
            });
        </script>
		<script src="../../js/custom/sport/addAssociation.js"></script> <!--Call relevant java script file  -->
    </body>

</html>
