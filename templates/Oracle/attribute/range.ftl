
-- evaluate business rule ${name}
declare
    l_passed    boolean := true;
begin
    if l_oper('INS','UPD') then
        l_passed := ${targetDatabaseAttribute} ${operator} ${value.minimum?c} and ${value.maximum?c};
        if not l_passed then
            l_error_stack := l_error_stack || '${targetDatabaseAttribute} must be ${operator} ${value.minimum?c} and ${value.maximum?c}.';
        end if;
    end if;
end;