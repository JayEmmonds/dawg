<%--

    Copyright 2010 Comcast Cable Communications Management, LLC

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

--%>
<!--
The number pad for the mini remote
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <div>
        <img id="mone" src='<c:url value="/images/remotes/shared/keys/one.png" />' onmousedown="clickRemoteButton(event,'ONE', true)" onmouseup="clickRemoteButton(event,'ONE', false)" alt="" style="width:27%;left:0%;top:0%;position:absolute" onmouseover="this.style.filter='progid:DXImageTransform.Microsoft.BasicImage(invert=1)'"/>
        <img id="mtwo" src='<c:url value="/images/remotes/shared/keys/two.png" />' onmousedown="clickRemoteButton(event,'TWO', true)" onmouseup="clickRemoteButton(event,'TWO', false)" alt="" style="width:27%;left:36%;top:0%;position:absolute"/>
        <img id="mthree" src='<c:url value="/images/remotes/shared/keys/three.png" />' onmousedown="clickRemoteButton(event,'THREE', true)" onmouseup="clickRemoteButton(event,'THREE', false)" alt="" style="width:27%;left:72%;top:0%;position:absolute"/>
    </div>
    <div>
        <img id="mfour" src='<c:url value="/images/remotes/shared/keys/four.png" />' onmousedown="clickRemoteButton(event,'FOUR', true)" onmouseup="clickRemoteButton(event,'FOUR', false)" alt="" style="width:27%;left:0%;top:28%;position:absolute"/>
        <img id="mfive" src='<c:url value="/images/remotes/shared/keys/five.png" />' onmousedown="clickRemoteButton(event,'FIVE', true)" onmouseup="clickRemoteButton(event,'FIVE', false)" alt="" style="width:27%;left:36%;top:28%;position:absolute"/>
        <img id="msix" src='<c:url value="/images/remotes/shared/keys/six.png" />' onmousedown="clickRemoteButton(event,'SIX', true)" onmouseup="clickRemoteButton(event,'SIX', false)" alt="" style="width:27%;left:72%;top:28%;position:absolute"/>
    </div>
    <div>
        <img id="mseven" src='<c:url value="/images/remotes/shared/keys/seven.png" />' onmousedown="clickRemoteButton(event,'SEVEN', true)" onmouseup="clickRemoteButton(event,'SEVEN', false)" alt="" style="width:27%;left:0%;top:56%;position:absolute;"/>
        <img id="meight" src='<c:url value="/images/remotes/shared/keys/eight.png" />' onmousedown="clickRemoteButton(event,'EIGHT', true)" onmouseup="clickRemoteButton(event,'EIGHT', false)" alt="" style="width:27%;left:36%;top:56%;position:absolute;"/>
        <img id="mnine" src='<c:url value="/images/remotes/shared/keys/nine.png" />' onmousedown="clickRemoteButton(event,'NINE', true)" onmouseup="clickRemoteButton(event,'NINE', false)" alt="" style="width:27%;left:72%;top:56%;position:absolute;"/>
    </div>
    <div>
        <img id="mchup" src='<c:url value="/images/remotes/shared/keys/chup.png" />' onmousedown="clickRemoteButton(event,'CHUP', true)" onmouseup="clickRemoteButton(event,'CHUP', false)" alt="" style="width:27%;left:0%;top:84%;position:absolute;"/>
        <img id="mzero" src='<c:url value="/images/remotes/shared/keys/zero.png" />' onmousedown="clickRemoteButton(event,'ZERO', true)" onmouseup="clickRemoteButton(event,'ZERO', false)" alt="" style="width:27%;left:36%;top:84%;position:absolute;"/>
        <img id="mchdn" src='<c:url value="/images/remotes/shared/keys/chdn.png" />' onmousedown="clickRemoteButton(event,'CHDN', true)" onmouseup="clickRemoteButton(event,'CHDN', false)" alt="" style="width:27%;left:72%;top:84%;position:absolute;"/>
    </div>
</html>
