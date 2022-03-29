import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:http/http.dart' as http;

import '../colors.dart';
import '../controllers/dispenser_controller.dart';

class LoginPage extends StatefulWidget {
  const LoginPage({Key? key}) : super(key: key);

  @override
  State<LoginPage> createState() => _LoginPageState();
}

class _LoginPageState extends State<LoginPage> {
  final _formKey = GlobalKey<FormState>();
  String _id = "", _pw = "";

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      resizeToAvoidBottomInset: false,
      body: SafeArea(
        child: SizedBox(
          height: double.infinity,
          child: Column(
            children: [
              Container(
                alignment: Alignment.centerRight,
                padding: EdgeInsets.only(top: 12, right: 20),
                child: Text("Sign Up",
                    style: TextStyle(color: PRIMARY_COLOR, fontSize: 16)),
              ),
              SizedBox(height: 72),
              Text("Login",
                  style: TextStyle(
                      color: GRAY_COLOR,
                      fontSize: 48,
                      fontWeight: FontWeight.bold)),
              SizedBox(height: 52),
              Padding(
                padding: const EdgeInsets.symmetric(horizontal: 24),
                child: Form(
                  key: _formKey,
                  child: Column(
                    children: [
                      Container(
                        width: double.infinity,
                        child: Text("ID", style: TextStyle(fontSize: 16)),
                      ),
                      SizedBox(height: 8),
                      TextFormField(
                          onSaved: (id) => _id = id ?? "",
                          validator: (id) {
                            if ((id ?? "").isEmpty) {
                              return '아이디를 입력하세요.';
                            }
                            return null;
                          },
                          obscureText: true,
                          decoration: InputDecoration(
                              hintText: "ID",
                              border: OutlineInputBorder(
                                  borderRadius:
                                      BorderRadius.all(Radius.circular(16))))),
                      SizedBox(height: 40),
                      Container(
                        width: double.infinity,
                        child: Text("Password", style: TextStyle(fontSize: 16)),
                      ),
                      SizedBox(height: 8),
                      TextFormField(
                          validator: (pw) {
                            if ((pw ?? "").isEmpty) {
                              return '비밀번호를 입력하세요.';
                            }
                            return null;
                          },
                          onSaved: (name) => _pw = name ?? "",
                          obscureText: true,
                          decoration: InputDecoration(
                              hintText: "Password",
                              border: OutlineInputBorder(
                                  borderRadius:
                                      BorderRadius.all(Radius.circular(16))))),
                    ],
                  ),
                ),
              ),
              Expanded(child: SizedBox.shrink()),
              Padding(
                padding: const EdgeInsets.symmetric(horizontal: 24),
                child: SizedBox(
                  height: 50,
                  width: double.infinity,
                  child: ElevatedButton(
                      onPressed: () async {
                        if (_formKey.currentState?.validate() ?? false) {
                          _formKey.currentState?.save();
                          print("$_id $_pw");
                          // await http.get(Uri.parse(
                          //     'http://34.64.122.168:8080/api/sign/login'));
                          final data = await http.get(
                              Uri.parse(
                                  'http://34.64.122.168:8080/api/dispenser'),
                              headers: {
                                "X-AUTH-TOKEN":
                                    "eyJyZWdEYXRlIjoxNjQ3MjcyMzE0ODU1LCJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJyb2xlIjoiUk9MRV9VU0VSIiwiZXhwIjoxNjQ5ODY0MzE0LCJ1c2VybmFtZSI6InRlc3QxIn0.Wh0DHofceOg-xFXCDrTSHcTwtKTw_-fZwUNMt1FoKuk"
                              });
                          DispenserController.to.dispenserList.value =
                              json.decode(utf8.decode(data.bodyBytes));
                          Get.toNamed("/home");
                          // http.
                        }
                      },
                      child: Text("Login"),
                      style: ButtonStyle(
                        backgroundColor:
                            MaterialStateProperty.all(PRIMARY_COLOR),
                      )),
                ),
              ),
              SizedBox(
                height: 16,
              )
            ],
          ),
        ),
      ),
    );
  }
}
