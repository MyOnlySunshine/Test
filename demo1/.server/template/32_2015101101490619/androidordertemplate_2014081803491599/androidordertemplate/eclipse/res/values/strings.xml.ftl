<resources>
    <string name="menu_settings">Settings</string>
    <string name="title_activity_main">MainActivity</string>
    <string name="${app_name}">${app_name}</string>
    
    <#if strings_name??>
    <#list strings_name as key>
       <string name="${key}">${strings_value[key_index]}</string>
    </#list>
    </#if>
    
</resources>