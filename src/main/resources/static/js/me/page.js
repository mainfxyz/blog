/**
 * url参数转json
 * @return json
 * */
var p2j = function (url) {  //获取url的参数
    var theRequest = new Object();
    if (url.indexOf("?") != -1) {
        var str = url.substr(1);
        strs = str.split("&");
        for (var i = 0; i < strs.length; i++) {
            theRequest[strs[i].split("=")[0]] = decodeURI(strs[i].split("=")[1]);
        }
    }
    return theRequest;
}
/**
 * json转url参数
 * @return String
 * */
var j2p = function (json) {
    var params = Object.keys(json).map(function (key) {
        return key + "=" + json[key];
    }).join("&");
    return params;
}

/**
 * 分页功能，jq方法生成dom
 * @now 现在的页数
 * @end 末页
 * **/
function initPage(now,end) {
    now*=1//转整数
    var p = []
    if (end <= 4) {
        for (var i = 1; i <= end && i <= 4; i++)
            p.push(i);
    } else if (now <= 4) {
        for (var i = 1; i <= end && i <= 6; i++)
            p.push(i);
        p.push('...');
        p.push(end);
    } else if (now <= end - 3) {
        p = [1, '...', now - 2, now - 1, now, now + 1, now + 2, '...', end];
    } else {
        p.push(1);
        p.push('...');
        for (var i = end - 4; i <= end; i++)
            p.push(i);
    }
    console.log(p);
    for (var i = 0; i < p.length; i++) {
        $li = $("<li></li>")
        $li.addClass("page-item");
        $a = $("<a></a>");
        $a.addClass("page-link");
        //链接计算
        var param = window.location.search;
        var json = p2j(param);

        json['page'] = p[i];
        param = '?' + j2p(json);
        //end计算
        if (p[i] == now) {
            $li.addClass("active");
            $a.addClass("text-light bg-dark");
            $a.attr("href", "?page=" + p[i]);
        } else if (p[i] == '...') {
            $('#page').append($("<li><a>...</a></li>"));
            continue;
        } else {
            $a.addClass("text-dark");
            $a.attr("href", param);
        }
        $a.text(p[i]);
        $li.append($a);
        $('#page').append($li).append($("<li><a>&nbsp;</a></li>"));
    }
}