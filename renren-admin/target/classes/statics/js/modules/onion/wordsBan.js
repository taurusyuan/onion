var status;
var idArray = new Array();
var testGroupNames = new Array();

var st =new Map();
st.set(1,"已审核通过");
st.set(2,"审核未通过");
st.set(3,"未审核");

var wordsBan_handler = new Vue({
    el:'#handle',
    data:{},
    mounted(){},
    methods:{
        testagentListsearch: function () {   /*查询监听事件*/
            var data = getFormJson($('#searchcolums'));
            /*得到查询条件*/
            /*获取表单元素的值*/
            console.log(data);
            wordsBan.probedata = data;
            wordsBan.redraw();
            /*根据查询条件重绘*/
        },
        reset:function () {
            wordsBan.reset();
        },
        testagentadd:function () {

        },
        testagentdelBatch:function () {

        }
    }
});

function getFormJson(form) {      /*将表单对象变为json对象*/
    var o = {};
    var a = $(form).serializeArray();
    $.each(a, function () {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
}

// 表格
var wordsBan = new Vue({
    el: '#probedata_table',
    data: {
        headers: [
            {title: ''},
            {title: '<div class="checkbox"> <label> <input type="checkbox" id="checkAll"></label> </div>'},
            // {title: '<div style="display:none">id</div>'},
            {title: '<div style="width:78px">违禁词条</div>'},
            {title: '<div style="width:67px">发表人</div>'},
            {title: '<div style="width:78px">审核状态</div>'},
            {title: '<div style="width:67px">创建时间</div>'},
            {title: '<div style="width:98px">操作</div>'}
        ],
        rows: [],
        dtHandle: null,
        probedata: {}

    },
    /*watch: {
     users(val, oldVal) {
     }
     },*/
    methods: {
        reset: function () {
            let vm = this;
            vm.probedata = {};
            /*清空probedata*/
            vm.dtHandle.clear();
            console.log("重置");
            vm.dtHandle.draw();
            /*重置*/
        },
        currReset: function () {
            let vm = this;
            vm.dtHandle.clear();
            console.log("当前页面重绘");
            vm.dtHandle.draw(false);
            /*当前页面重绘*/
        },
        redraw: function () {
            let vm = this;
            vm.dtHandle.clear();
            console.log("页面重绘");
            vm.dtHandle.draw();
            /*重绘*/
        }
    },
    mounted:function() {
        let vm = this;
        // Instantiate the datatable and store the reference to the instance in our dtHandle element.
        vm.dtHandle = $(this.$el).DataTable({
            columns: vm.headers,
            data: vm.rows,
            searching: false,
            paging: true,
            serverSide: true,
            info: false,
            ordering: false, /*禁用排序功能*/
            /*bInfo: false,*/

            /*bLengthChange: false,*/    /*禁用Show entries*/
            /*scrollY: 432,    /!*表格高度固定*!/*/
            oLanguage: {
                sLengthMenu: "每页 _MENU_ 行数据",
                oPaginate: {
                    sNext: '<i class="fa fa-chevron-right" ></i>', /*图标替换上一页,下一页*/
                    sPrevious: '<i class="fa fa-chevron-left" ></i>'
                }
            },
            sDom: 'Rfrtlip', /*显示在左下角*/
            ajax: function (data, callback, settings) {
                //封装请求参数
                let param = {};
                param.limit = data.length;//页面显示记录条数，在页面显示每页显示多少项的时候
                param.start = data.start;//开始的记录序号
                param.page = (data.start / data.length) + 1;//当前页码
                param.probedata = JSON.stringify(vm.probedata);
                /*用于查询probe数据*/
                console.log(param);
                //ajax请求数据
                $.ajax({
                    type: "POST", /*GET会乱码*/
                    url: "../../wordsban/list",
                    cache: false,  //禁用缓存
                    data: param,  //传入组装的参数
                    dataType: "json",
                    success: function (result) {
                        console.log(result);
                        //封装返回数据
                        let returnData = {};
                        returnData.draw = data.draw;//这里直接自行返回了draw计数器,应该由后台返回
                        returnData.recordsTotal = result.page.totalCount;//返回数据全部记录
                        returnData.recordsFiltered = result.page.totalCount;//后台不实现过滤功能，每次查询均视作全部结果
                        // returnData.data = result.page.list;//返回的数据列表
                        // 重新整理返回数据以匹配表格
                        let rows = [];
                        var i = param.start+1;
                        result.page.list.forEach(function (item) {
                            let row = [];
                            row.push(i++);
                            row.push('<div class="checkbox"> <label> <input type="checkbox" name="selectFlag"></label> </div>');
                            // row.push('<div class="probe_id">'+item.id+'</div>');
                            row.push(item.word);
                            row.push(item.postPeople);
                            row.push(st.get(item.approvalState));
                            row.push(item.createTime);
                            row.push('<a class="fontcolor" onclick="delete_this(this)" id='+item.id+'>编辑</a>&nbsp'+
                                '<a class="fontcolor" onclick="delete_this(this)" id='+item.id+'>删除</a>&nbsp'+
                                '<a class="fontcolor" onclick="delete_this(this)" id='+item.id+'>查看</a>');
                            rows.push(row);
                        });
                        returnData.data = rows;
                        console.log(returnData);
                        //调用DataTables提供的callback方法，代表数据已封装完成并传回DataTables进行渲染
                        //此时的数据需确保正确无误，异常判断应在执行此回调前自行处理完毕
                        callback(returnData);
                    }
                });
            }
        });
    }
});


