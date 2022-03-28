import 'dart:convert';
import 'dart:ui';

import 'package:flutter/material.dart';
import 'package:flutter_app/controllers/dispenser_controller.dart';
import 'package:get/get.dart';
import 'package:google_maps_flutter/google_maps_flutter.dart';
import 'package:http/http.dart' as http;

class ManagePage extends StatefulWidget {
  const ManagePage({Key? key}) : super(key: key);

  @override
  State<ManagePage> createState() => _ManagePageState();
}

class _ManagePageState extends State<ManagePage> {
  int idx = 0;
  final DispenserController _controller = DispenserController.to;

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
          BottomSheet()
        ],
      ),
    );
  }
}

class BottomSheet extends GetView<DispenserController> {
  @override
  Widget build(BuildContext context) {
    return DraggableScrollableSheet(
      initialChildSize: 0.30,
      minChildSize: 0.2,
      builder: (context, scrollController) => SingleChildScrollView(
        controller: scrollController,
        child: Column(
          children: [
            Container(
                height: 48,
                decoration: const BoxDecoration(
                  color: Colors.white,
                  borderRadius: BorderRadius.vertical(top: Radius.circular(24)),
                )),
            Container(
              color: Colors.white,
              height: MediaQuery.of(context).size.height - 125,
              child: Obx(
                () => ListView.separated(
                  separatorBuilder: (BuildContext context, int index) {
                    return Divider(
                      height: 0,
                    );
                  },
                  controller: scrollController,
                  shrinkWrap: true,
                  physics: NeverScrollableScrollPhysics(),
                  itemBuilder: (context, idx) => Material(
                    color: Colors.white,
                    child: InkWell(
                      onTap: () async {
                        final data = await http.get(
                            Uri.parse(
                                'http://34.64.122.168:8080/api/dispenser/${controller.dispenserList[idx]["id"]}'),
                            headers: {
                              "X-AUTH-TOKEN":
                                  "eyJyZWdEYXRlIjoxNjQ3MjcyMzE0ODU1LCJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJyb2xlIjoiUk9MRV9VU0VSIiwiZXhwIjoxNjQ5ODY0MzE0LCJ1c2VybmFtZSI6InRlc3QxIn0.Wh0DHofceOg-xFXCDrTSHcTwtKTw_-fZwUNMt1FoKuk"
                            });
                        controller.dispenser.value = json.decode(utf8.decode(data.bodyBytes));
                        Get.toNamed("/detail/$idx");
                      },
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
                            const SizedBox(
                              width: 16,
                            ),
                            Column(
                              crossAxisAlignment: CrossAxisAlignment.start,
                              children: [
                                Text(
                                  controller.dispenserList[idx]["code"],
                                  style: TextStyle(fontSize: 16),
                                ),
                                Text(controller.dispenserList[idx]["location"],
                                    style: TextStyle(fontSize: 12))
                              ],
                            )
                          ],
                        ),
                      ),
                    ),
                  ),
                  itemCount: controller.dispenserList.length,
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
