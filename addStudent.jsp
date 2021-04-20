<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
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

            <!-- Sidebar -->
           	<jsp:include page="../common/sidebar.jsp" />
            <!-- End of Sidebar -->

            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content">

                    <!-- Topbar -->
                    <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

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

                    <!-- Begin Page Content -->
                    <div class="container-fluid">

                        <h1 class="h3 mb-4 text-gray-800">Add Student Details</h1>
						<!-- action="/SchoolManagementSystem/addStudent" name="addStudentForm" method="post" onSubmit="return validateSubmit(event);" -->
                        <form class="user" id="addStudentForm">
                            <div class="form-group">
                                <label>Full Name</label>
                                <input type="text" id="fullName" name="fullName" class="form-control form-control-user" id="exampleInputEmail" placeholder="Full Name">
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <label>First Name</label>
                                    <input type="text" id="firstName" name="firstName" class="form-control form-control-user" id="exampleFirstName" placeholder="First Name">
                                </div>
                                <div class="col-sm-6">
                                    <label>Last Name</label>
                                    <input type="text" id="lastName" name="lastName" class="form-control form-control-user" id="exampleLastName" placeholder="Last Name">
                                </div>
                            </div>

                            <div class="form-group">
                                <label>Select Gender</label>
                                <select id="gender" name="gender" class="form-control">
                                    <option>Male</option>
                                    <option>Female</option>
                                </select>
                            </div>
                            
                            <div class="form-group">
                                <label>Date Of Birth</label>
                                <input type="date" id="dob" name="dob" class="form-control form-control-user" id="exampleInputEmail">
                            </div>
                            
                            <div class="form-group">
                                <label>Address</label>
                                <input type="text" id="address" name="address" class="form-control form-control-user" id="exampleInputEmail" placeholder="Address">
                            </div>

                            <div class="form-group">
                                <label>Guardian Name</label>
                                <input type="text" id="guardian" name="guardian" class="form-control form-control-user" id="exampleInputEmail" placeholder="Guardian Name">
                            </div>
                            
                            <div class="form-group">
                                <label>Contact Number</label>
                                <input type="text" id="cNumber" name="cNumber" class="form-control form-control-user" id="exampleInputEmail" placeholder="Contact Number">
                            </div>
                            
                            <div class="form-group">
                                <label>Occupation</label>
                                <input type="text" id="occupation" name="occupation" class="form-control form-control-user" id="exampleInputEmail" placeholder="Occupation">
                            </div>
                            
                            <div class="form-group">
                                <label>Admission Date</label>
                                <input type="date" id="addmissionDate" name="addmissionDate" class="form-control form-control-user" id="exampleInputEmail">
                            </div>
                            
                            <div class="form-group">
                                <label>Admission Number</label>
                                <input type="text" id="admissionNo" name="admissionNo" class="form-control form-control-user" id="exampleInputEmail" placeholder="Admission Number">
                            </div>
                            
                            <input type="submit" id="submitBtn" onclick="validateSubmit(event)" class="btn btn-primary btn-user btn-block" value="Save Student">
                            <hr>
                        </form>


                    </div>
                    <!-- /.container-fluid -->

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
        
        <script src="../../js/custom/students/addStudent.js"></script>

    </body>
</html>
