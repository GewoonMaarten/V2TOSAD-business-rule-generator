create or replace trigger ${name}
    before delete or insert or update
    on ${table}
    for each row
declare
    l_oper          varchar2(3);
    l_error_stack   varchar2(4000);
begin
    case
        when INSERTING then
            l_oper := 'INS';
        when UPDATING then
            l_oper := 'UPD';
        when DELETING then
            l_open := 'DEL';
    end case;

    <#list generatedTriggers as generatedTrigger>
        ${generatedTrigger}
    </#list>

end ${name};
