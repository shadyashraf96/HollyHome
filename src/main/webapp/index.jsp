<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Real Estate Rentals</title>
    <!-- Bootstrap CSS for responsive layout -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- FontAwesome for icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <!-- Custom CSS for specific styling -->
    <link rel="stylesheet" href="assets/css/style.css">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container">
        <a class="navbar-brand" href="#">RealEstateRental</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav ml-auto">
                <a class="nav-item nav-link active" href="#">Home <span class="sr-only">(current)</span></a>
                <a class="nav-item nav-link" href="about.jsp">About Us</a>
                <a class="nav-item nav-link" href="contact.jsp">Contact</a>
            </div>
        </div>
    </div>
</nav>

<div class="hero-section py-5 bg-light text-center">
    <div class="container">
        <h1>Welcome to Real Estate Rentals</h1>
        <p>Find your perfect rental home.</p>
        <form class="form-inline justify-content-center">
            <!-- Area Filter -->
            <select class="form-control mr-sm-2" name="area">
                <option value="">Select Area</option>
                <option value="north">North</option>
                <option value="south">South</option>
                <option value="east">East</option>
                <option value="west">West</option>
            </select>
            <!-- City Filter -->
            <select class="form-control mr-sm-2" name="city">
                <option value="">Select City</option>
                <option value="city1">City 1</option>
                <option value="city2">City 2</option>
                <option value="city3">City 3</option>
            </select>
            <!-- Property Type Filter -->
            <select class="form-control mr-sm-2" name="propertyType">
                <option value="">Property Type</option>
                <option value="apartment">Apartment</option>
                <option value="house">House</option>
                <option value="villa">Villa</option>
                <option value="studio">Studio</option>
            </select>
            <!-- Search Button -->
            <button class="btn btn-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</div>

<div class="container my-5">
    <h2>Featured Properties</h2>
    <div class="row">
        <!-- Sample Property 1 -->
        <div class="col-md-4 mb-4">
            <div class="card">
                <img src="assets/images/sample-property1.jpg" class="card-img-top" alt="Sample Property 1">
                <div class="card-body">
                    <h5 class="card-title">Modern Apartment</h5>
                    <p class="card-text">2 Beds, 2 Baths, Downtown Location</p>
                    <a href="#" class="btn btn-primary">View Details</a>
                </div>
            </div>
        </div>
        <!-- Sample Property 2 -->
        <div class="col-md-4 mb-4">
            <div class="card">
                <img src="assets/images/sample-property2.jpg" class="card-img-top" alt="Sample Property 2">
                <div class="card-body">
                    <h5 class="card-title">Cozy Studio</h5>
                    <p class="card-text">1 Bed, 1 Bath, Ocean View</p>
                    <a href="#" class="btn btn-primary">View Details</a>
                </div>
            </div>
        </div>
        <!-- Sample Property 3 -->
        <div class="col-md-4 mb-4">
            <div class="card">
                <img src="assets/images/sample-property3.jpg" class="card-img-top" alt="Sample Property 3">
                <div class="card-body">
                    <h5 class="card-title">Spacious Villa</h5>
                    <p class="card-text">4 Beds, 3 Baths, Large Backyard</p>
                    <a href="#" class="btn btn-primary">View Details</a>
                </div>
            </div>
        </div>
    </div>
</div>

<footer class="text-center text-lg-start bg-primary text-muted">
    <div class="text-center p-4 text-white">
        © 2024 Real Estate Rentals, Inc.
    </div>
</footer>

<!-- Bootstrap JS, Popper.js, and jQuery for interactive components -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
