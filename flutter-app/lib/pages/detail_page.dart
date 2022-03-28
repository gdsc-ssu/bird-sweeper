import 'package:flutter/material.dart';
import 'package:flutter_app/controllers/dispenser_controller.dart';
import 'package:get/get.dart';
import 'package:google_maps_flutter/google_maps_flutter.dart';

class DetailPage extends GetView<DispenserController> {
  late final Map data = controller.dispenser;

  @override
  Widget build(BuildContext context) {
    print(data);
    return Scaffold(
      body: SafeArea(
        child: SingleChildScrollView(
          child: Container(
            padding: EdgeInsets.symmetric(horizontal: 24, vertical: 24),
            child: Column(
              children: [
                SizedBox(
                  width: double.infinity,
                  child: Card(
                    child: Padding(
                      padding: const EdgeInsets.only(top: 24, bottom: 16),
                      child: Column(
                        children: [
                          Text(
                            data["dispenser"]["code"],
                            style: TextStyle(
                                fontSize: 24,
                                color: Color(0xFF292927),
                                fontWeight: FontWeight.bold),
                          ),
                          SizedBox(
                            height: 2,
                          ),
                          Text(
                            "Renewaled : ${DateTime.now().difference(DateTime.parse(data["dispenser"]["updatedDate"].toString()))} ago",
                            style: TextStyle(
                                fontSize: 14, color: Color(0xFF292927)),
                          ),
                          Padding(padding: EdgeInsets.all(24)),
                          Padding(
                              padding: EdgeInsets.symmetric(
                                  horizontal: 24, vertical: 8),
                              child: Row(
                                mainAxisAlignment:
                                    MainAxisAlignment.spaceBetween,
                                children: [
                                  Text(
                                    "Feed Count",
                                    style: TextStyle(
                                        color: Color(0xFF858580), fontSize: 14),
                                  ),
                                  Text(
                                    data["dispenser"]["feedCnt"].toString(),
                                    style: TextStyle(
                                        color: Color(0xFF292927), fontSize: 16),
                                  )
                                ],
                              )),
                        ],
                      ),
                    ),
                  ),
                ),
                SizedBox(
                  height: 20,
                ),
                SizedBox(
                  width: double.infinity,
                  child: Card(
                    child: Padding(
                      padding: const EdgeInsets.only(
                          top: 24, bottom: 16, left: 24, right: 24),
                      child: Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          Text(
                            "Equipment Detail",
                            style: TextStyle(
                                fontSize: 24,
                                color: Color(0xFF292927),
                                fontWeight: FontWeight.bold),
                          ),
                          SizedBox(
                            height: 2,
                          ),
                          Text(
                            "Renewaled : 10 min ago",
                            style: TextStyle(
                                fontSize: 14, color: Color(0xFF292927)),
                          ),
                          Padding(padding: EdgeInsets.all(24)),
                          Padding(
                              padding: EdgeInsets.symmetric(vertical: 8),
                              child: Row(
                                mainAxisAlignment:
                                    MainAxisAlignment.spaceBetween,
                                children: [
                                  Column(
                                    crossAxisAlignment:
                                        CrossAxisAlignment.start,
                                    children: [
                                      Text(
                                        "Battery",
                                        style: TextStyle(
                                            color: Color(0xFF858580),
                                            fontSize: 14),
                                      ),
                                      Text(
                                        data["dispenser"]["status"],
                                        style: TextStyle(
                                            color: Color(0xFF292927),
                                            fontSize: 16),
                                      )
                                    ],
                                  ),
                                  Text(
                                    data["dispenser"]["status"],
                                    style: TextStyle(
                                        color: Color(0xFF292927), fontSize: 16),
                                  )
                                ],
                              )),
                          Padding(
                              padding: EdgeInsets.symmetric(vertical: 8),
                              child: Row(
                                mainAxisAlignment:
                                    MainAxisAlignment.spaceBetween,
                                children: [
                                  Column(
                                    crossAxisAlignment:
                                        CrossAxisAlignment.start,
                                    children: [
                                      Text(
                                        "Residual food",
                                        style: TextStyle(
                                            color: Color(0xFF858580),
                                            fontSize: 14),
                                      ),
                                      Text(
                                        data["feedPercent"].toString(),
                                        style: TextStyle(
                                            color: Color(0xFF292927),
                                            fontSize: 16),
                                      )
                                    ],
                                  ),
                                  Text(
                                    (data["feedPercent"]).toString(),
                                    style: TextStyle(
                                        color: Color(0xFF292927), fontSize: 16),
                                  )
                                ],
                              )),
                          Padding(
                              padding: EdgeInsets.symmetric(vertical: 8),
                              child: Row(
                                mainAxisAlignment:
                                    MainAxisAlignment.spaceBetween,
                                children: [
                                  Text(
                                    "Manager",
                                    style: TextStyle(
                                        color: Color(0xFF858580), fontSize: 14),
                                  ),
                                  Text(
                                    data["dispenser"]["createdUser"],
                                    style: TextStyle(
                                        color: Color(0xFF292927), fontSize: 16),
                                  )
                                ],
                              )),
                          Padding(
                              padding: EdgeInsets.symmetric(vertical: 8),
                              child: Row(
                                mainAxisAlignment:
                                    MainAxisAlignment.spaceBetween,
                                children: [
                                  Text(
                                    "Install Date",
                                    style: TextStyle(
                                        color: Color(0xFF858580), fontSize: 14),
                                  ),
                                  Text(
                                    data["dispenser"]["createdDate"],
                                    style: TextStyle(
                                        color: Color(0xFF292927), fontSize: 16),
                                  )
                                ],
                              ))
                        ],
                      ),
                    ),
                  ),
                ),
                SizedBox(
                  height: 20,
                ),
                SizedBox(
                  width: double.infinity,
                  child: Card(
                    child: Padding(
                      padding: const EdgeInsets.only(
                          top: 24, bottom: 16, left: 24, right: 24),
                      child: Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          Text(
                            "Location",
                            style: TextStyle(
                                fontSize: 24,
                                color: Color(0xFF292927),
                                fontWeight: FontWeight.bold),
                          ),
                          SizedBox(
                            height: 2,
                          ),
                          Text(
                            data["dispenser"]["location"],
                            style: TextStyle(
                                fontSize: 14, color: Color(0xFF292927)),
                          ),
                          Padding(padding: EdgeInsets.all(8)),
                          Padding(
                              padding: EdgeInsets.symmetric(vertical: 8),
                              child: SizedBox(
                                height: 320,
                                width: double.infinity,
                                child: GoogleMap(
                                  mapType: MapType.hybrid,
                                  initialCameraPosition: CameraPosition(
                                    target: LatLng(
                                        double.parse(
                                            data["dispenser"]["latitude"]),
                                        double.parse(
                                            data["dispenser"]["longitude"])),
                                    zoom: 14.4746,
                                  ),
                                  // onMapCreated: (GoogleMapController controller) {
                                  //   _controller.complete(controller);
                                  // },
                                ),
                              ))
                        ],
                      ),
                    ),
                  ),
                )
              ],
            ),
          ),
        ),
      ),
      backgroundColor: const Color(0xFFF6F6F8),
    );
  }
}
