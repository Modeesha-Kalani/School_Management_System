
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Information Management System</title>

        <!-- Custom fonts for this template-->
        <link href="../../vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
        <link rel="stylesheet" href="../../plugins/select2/css/select2.min.css">
        <link rel="stylesheet" href="../../plugins/select2-bootstrap4-theme/select2-bootstrap4.min.css">
        <!-- Custom styles for this template-->
        <link href="../../css/sb-admin-2.min.css" rel="stylesheet">

    </head>

    <body id="page-top">

        <!-- Page Wrapper -->
        <div id="wrapper">

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

                    <div class="container-fluid">

                        <h1 class="h3 mb-4 text-gray-800">Add Time Table Details</h1>

                        <form class="user" name="addTimeTableForms">
                            <div class="form-group">
                                <span id="newId" class="badge badge-success"></span>
                                <input type="hidden" id="nextId">
                            </div>
                            <div class="form-group">
                                <label>Section</label>
                                <input type="text" name="section_text" class="form-control form-control-user" id="section_text" placeholder="Section">
                            </div>
                            <div class="form-group">
                                <label>Grade</label>
                                <input type="text" name="grade_text" class="form-control form-control-user" id="grade_text" placeholder="Grade">
                            </div>
                            
                            <div class="form-group">
                                <label>Class</label>
                                <input type="text" name="class_text" class="form-control form-control-user" id="class_text" placeholder="Class">
                            </div>
                            
                            <div class="form-group">
                                <label>Select Day</label>
                                <select class="form-control select2" id="day">
                                    <option >Monday</option>
                                    <option >Tuesday</option>
                                    <option >Wednesday</option>
                                    <option >Thursday</option>
                                    <option >Friday</option>
                                </select>
                            </div>
                            
                             <div class="form-group">
                                <label>Select Period</label>
                                <select class="form-control select2" id="period">
                                    <option >1st Period</option>
									<option >2nd Period</option>
									<option >3rd Period</option>
									<option >4th Period</option>
									<option >5th Period</option>
									<option >6th Period</option>
									<option >7th Period</option>
									<option >8th Period</option>
                                </select>
                            </div>
                            
                            <div class="form-group">
                                <label>Select Teacher</label>
                                <select class="form-control select2" id="teacher">
                                    
                                </select>
                            </div>
                            
                            
                            <div class="form-group">
                                <label>Select Subject</label>
                                <select class="form-control select2" id="all_subject">
                                    
                                </select>
                            </div>
                            
                           
                            
                        </form>


                    </div>
                    <!-- /.container-fluid -->
				
				
				<div class="container-fluid">

					<br><br>
                            <input type="submit" onclick="addToTimetable(event)" name="addTimeTable" class="btn btn-success btn-user btn-block" value="Add To Table">
                            <br>

					<h1 class="h3 mb-4 text-gray-800">Time Table Details</h1>

					<div class="card-body">
						<div class="table-responsive">
							<table class="table table-bordered table-striped" id="timetable">
								<thead>
									<tr>
										<th>Day</th>
										<th>Period</th>
										<th>Teacher Name</th>
										<th>Subject</th>
										<th>Close</th>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>

						</div>
					</div>
					
					<br><br>
                            <input type="submit" onclick="validateSubmit(event)" name="addTimeTable" class="btn btn-success btn-user btn-block" value="Save Time Table">
                            <br>


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
         <script src="../../plugins/select2/js/select2.full.min.js"></script>
        <script>
            $(function () {
                $('.select2').select2();
                $('.select2bs4').select2({
                    theme: 'bootstrap4'
                });
            });
        </script>
        <script src="../../js/custom/time_table/addTimeTable.js"></script>

    </body>

</html>
