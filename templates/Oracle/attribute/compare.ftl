--evaluate business rule ${businessRuleName}
declare
l_passed    boolean := true;
begin
if l_oper('INS','UPD') then
l_passed := ${targetDatabaseAttribute1} ${operator} ${compare};
if not l_passed then
l_error_stack := l_error_stack || '${targetDatabaseAttribute1} must be ${operator} to ${compare}.';
end if;
end if;
end;
