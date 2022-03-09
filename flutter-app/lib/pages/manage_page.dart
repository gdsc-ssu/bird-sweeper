import 'package:flutter/material.dart';

class ManagePage extends StatefulWidget {
  const ManagePage({Key? key}) : super(key: key);

  @override
  State<ManagePage> createState() => _ManagePageState();
}

class _ManagePageState extends State<ManagePage> {
  int idx = 0;

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        Text("Garbage collected",
            style: TextStyle(color: Color(0xFF858580), fontSize: 14))
      ],
    );
  }
}
