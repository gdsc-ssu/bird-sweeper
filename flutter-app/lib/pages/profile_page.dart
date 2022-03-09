import 'package:flutter/material.dart';

class ProfilePage extends StatefulWidget {
  const ProfilePage({Key? key}) : super(key: key);

  @override
  State<ProfilePage> createState() => _ProfilePageState();
}

class _ProfilePageState extends State<ProfilePage> {
  int idx = 0;

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        Text("Garbage collecte12d",
            style: TextStyle(color: Color(0xFF858580), fontSize: 14))
      ],
    );
  }
}
