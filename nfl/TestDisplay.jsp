<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>NFL 22 Point Pool - Standings</title>
    <!-- Bootstrap core CSS -->
<!--     <link href="dist/css/bootstrap.css" rel="stylesheet"> -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<jsp:include page="../masterinclude.jsp"></jsp:include>
	<!-- Remote -->
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <!-- jQWidgets CSS -->
    <link href="..//jqwidgets/styles/jqx.base.css" rel="stylesheet">
    <link href="..//jqwidgets/styles/jqx.bootstrap.css" rel="stylesheet">
        <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
<!--     <script src="https://code.jquery.com/jquery-1.11.1.min.js"></script> -->
<!--     <script src="dist/js/bootstrap.min.js"></script> -->
    <!-- jQWidgets core JavaScript -->
    <script src="..//jqwidgets/jqxcore.js"></script>
    <!-- ================================================== -->
    <!-- Add addition JavaScript files here -->
    <script type="text/javascript">
        $(document).ready(function () {
        	var url = "../sampledata/products.xml";
        	var source =
            {
                datatype: "xml",
                datafields: [
                    { name: 'ProductName', type: 'string' },
                    { name: 'QuantityPerUnit', type: 'int' },
                    { name: 'UnitPrice', type: 'float' },
                    { name: 'UnitsInStock', type: 'float' },
                    { name: 'Discontinued', type: 'bool' }
                ],
                root: "Products",
                record: "Product",
                id: 'ProductID',
                url: url
            };
        	var cellsrenderer = function (row, columnfield, value, defaulthtml, columnproperties, rowdata) {
                if (value < 20) {
                    return '<span style="margin: 4px; float: ' + columnproperties.cellsalign + '; color: #ff0000;">' + value + '</span>';
                }
                else {
                    return '<span style="margin: 4px; float: ' + columnproperties.cellsalign + '; color: #008000;">' + value + '</span>';
                }
            }
            var dataAdapter = new $.jqx.dataAdapter(source, {
                downloadComplete: function (data, status, xhr) { },
                loadComplete: function (data) { },
                loadError: function (xhr, status, error) { }
            });
            // initialize jqxGrid
            $("#jqxgrid").jqxGrid(
            {
                width: 850,
                source: dataAdapter,                
                pageable: true,
                autoheight: true,
                sortable: true,
                altrows: true,
                enabletooltips: true,
                editable: true,
                selectionmode: 'multiplecellsadvanced',
                columns: [
                  { text: 'Product Name', columngroup: 'ProductDetails', datafield: 'ProductName', width: 250 },
                  { text: 'Quantity per Unit', columngroup: 'ProductDetails', datafield: 'QuantityPerUnit', cellsalign: 'right', align: 'right', width: 200 },
                  { text: 'Unit Price', columngroup: 'ProductDetails', datafield: 'UnitPrice', align: 'right', cellsalign: 'right', cellsformat: 'c2', width: 200 },
                  { text: 'Units In Stock', datafield: 'UnitsInStock', cellsalign: 'right', cellsrenderer: cellsrenderer, width: 100 },
                  { text: 'Discontinued', columntype: 'checkbox', datafield: 'Discontinued' }
                ],
                columngroups: [
                    { text: 'Product Details', align: 'center', name: 'ProductDetails' }
                ]
            });
        });
    </script>
</head>
<body>
    <h1>Hello, world!</h1>

    <body class='default'>
    <div id='jqxWidget' style="font-size: 13px; font-family: Verdana; float: left;">
        <div id="jqxgrid">
        </div>
     </div>
</body>
</body>
</html>