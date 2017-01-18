--evaluate business rule ${name}

declare
    l_passed    boolean := true;
begin
    if l_oper('INS','UPD') then
        l_passed := ${attribute1} ${operator} ${attribute2}
        if not l_passed then
            l_error_stack := l_error_stack || '${attribute1} must be ${operator} to ${attribute2}.'
        end if;
    end if;
end;