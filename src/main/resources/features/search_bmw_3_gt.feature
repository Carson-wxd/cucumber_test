#Feature: 用来描述我们需要测试的功能
#Scenario:用来描述具体的测试场景
#Given:前置条件
#When:描述测试步骤
#Then:断言 


Feature: BMW3系GT
     作为消费者想要知道最新款的BMW3系GT的价格
@BMW3GT
  Scenario: 查看最新款的BMW3系GT的价格
    Given  打开浏览器，进入百度的网页
    When  在浏览器框中输入"BMW 中国"
    Then   点击百度搜索按钮
    Then  页面跳转,查看页面是否存在宝马中国链接
    When  点击宝马中国链接
    Then 查看是否跳转到宝马中国页面
    When 滑动滚动条到新2019款BMW3系GT的位置
    When 点击新2019款BMW3系GT
    When 点击了解详情
    When 滑动滚动条到金融重购绿色通道位置
    Then 查看悠贷金融方案中320iM运动套装车价
    
    