import 'package:flutter/material.dart';
import 'package:flutter_app/colors.dart';
import 'package:get/get.dart';

import '../controllers/bottomtab_controller.dart';

class HomePage extends GetView<BottomTabController> {
  @override
  Widget build(BuildContext context) {
    print(controller.currentIndex());
    return Obx(
      () => Scaffold(
        bottomNavigationBar: BottomNavigationBar(
          selectedItemColor: PRIMARY_COLOR,
          currentIndex: controller.currentIndex(),
          onTap: (value) {
            controller.changePage(value);
          },
          items: [
            BottomNavigationBarItem(icon: Icon(Icons.abc), label: "Manage"),
            BottomNavigationBarItem(icon: Icon(Icons.abc), label: "Report"),
            BottomNavigationBarItem(icon: Icon(Icons.abc), label: "Profile")
          ],
        ),
        body: SafeArea(
          child: Container(
            child: controller.currentPage,
          ),
        ),
      ),
    );
  }
}
