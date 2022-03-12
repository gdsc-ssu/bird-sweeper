import 'package:flutter/material.dart';
import 'package:google_maps_flutter/google_maps_flutter.dart';

class ManagePage extends StatefulWidget {
  const ManagePage({Key? key}) : super(key: key);

  @override
  State<ManagePage> createState() => _ManagePageState();
}

class _ManagePageState extends State<ManagePage> {
  int idx = 0;

  static final CameraPosition _kGooglePlex = CameraPosition(
    target: LatLng(37.5642135, 127.0016985),
    zoom: 14.4746,
  );

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Stack(
        children: [
          GoogleMap(
            mapType: MapType.hybrid,
            initialCameraPosition: _kGooglePlex,
            // onMapCreated: (GoogleMapController controller) {
            //   _controller.complete(controller);
            // },
          ),
          DraggableScrollableSheet(
            initialChildSize: 0.30,
            minChildSize: 0.2,
            builder: (context, scrollController) => Material(
              color: Colors.white,
              child: ListView.builder(
                controller: scrollController,
                itemBuilder: (context, index) => InkWell(
                  onTap: () => print("hello"),
                  child: Padding(
                    padding: const EdgeInsets.symmetric(
                        horizontal: 20, vertical: 16),
                    child: Row(
                      children: [
                        ClipOval(
                          child: Container(
                            width: 32,
                            height: 32,
                            color: Colors.red,
                          ),
                        ),
                        SizedBox(
                          width: 16,
                        ),
                        Column(
                          children: [Text("aaa"), Text("aaa")],
                        )
                      ],
                    ),
                  ),
                ),
                itemCount: 25,
              ),
            ),
          )
        ],
      ),
    );
  }
}
