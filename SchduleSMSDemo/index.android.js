/**
 * Created by Ajay on 30/8/2017.
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from "react";
import { AppRegistry, StyleSheet, Button, View } from "react-native";
import Scheduler from "react-native-schedule-sms";

export default class SchduleSMSDemo extends Component {
  
  constructor(props) {
    super(props);
    this._pressSendMessage = this._pressSendMessage.bind(this);
  }

  render() {
    return (
      <View style={styles.container}>
        <Button
          onPress={this._pressSendMessage}
          title="Send Message"
          color="#841584"
        />
      </View>
    );
  }

  _pressSendMessage() {
    //Date and Time format Thu Aug 31 02:00:00 2017
    Scheduler.sendMessage("mobileNumber", "message", "time");
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
    backgroundColor: "#F5FCFF"
  },
  welcome: {
    fontSize: 20,
    textAlign: "center",
    margin: 10
  },
  instructions: {
    textAlign: "center",
    color: "#333333",
    marginBottom: 5
  }
});

AppRegistry.registerComponent("SchduleSMSDemo", () => SchduleSMSDemo);
