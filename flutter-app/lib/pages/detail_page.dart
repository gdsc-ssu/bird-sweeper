import 'package:flutter/material.dart';
import 'package:get/get.dart';

class DetailPage extends StatefulWidget {
  const DetailPage({Key? key}) : super(key: key);

  @override
  State<DetailPage> createState() => _DetailPageState();
}

class _DetailPageState extends State<DetailPage> {
  @override
  void initState() {
    super.initState();
    WidgetsBinding.instance?.addPostFrameCallback((_) {
      print(Get.parameters['idx']);
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(
        child: Container(
          padding: EdgeInsets.symmetric(horizontal: 24),
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
                          "Need to be replaced",
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
                          style:
                              TextStyle(fontSize: 14, color: Color(0xFF292927)),
                        ),
                        Padding(padding: EdgeInsets.all(24)),
                        Padding(
                            padding: EdgeInsets.symmetric(
                                horizontal: 24, vertical: 8),
                            child: Row(
                              mainAxisAlignment: MainAxisAlignment.spaceBetween,
                              children: [
                                Text(
                                  "Visits",
                                  style: TextStyle(
                                      color: Color(0xFF858580), fontSize: 14),
                                ),
                                Text(
                                  "14",
                                  style: TextStyle(
                                      color: Color(0xFF292927), fontSize: 16),
                                )
                              ],
                            )),
                        Padding(
                            padding: EdgeInsets.symmetric(
                                horizontal: 24, vertical: 8),
                            child: Row(
                              mainAxisAlignment: MainAxisAlignment.spaceBetween,
                              children: [
                                Text(
                                  "Visits",
                                  style: TextStyle(
                                      color: Color(0xFF858580), fontSize: 14),
                                ),
                                Text(
                                  "14",
                                  style: TextStyle(
                                      color: Color(0xFF292927), fontSize: 16),
                                )
                              ],
                            )),
                        Padding(
                            padding: EdgeInsets.symmetric(
                                horizontal: 24, vertical: 8),
                            child: Row(
                              mainAxisAlignment: MainAxisAlignment.spaceBetween,
                              children: [
                                Text(
                                  "Visits",
                                  style: TextStyle(
                                      color: Color(0xFF858580), fontSize: 14),
                                ),
                                Text(
                                  "14",
                                  style: TextStyle(
                                      color: Color(0xFF292927), fontSize: 16),
                                )
                              ],
                            )),
                      ],
                    ),
                  ),
                ),
              )
            ],
          ),
        ),
      ),
      backgroundColor: const Color(0xFFF6F6F8),
    );
  }
}
