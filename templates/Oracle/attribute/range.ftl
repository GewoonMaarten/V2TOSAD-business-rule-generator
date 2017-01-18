-- evaluate business rule ${name}
declare
    l_passed    boolean := true;
begin
    if l_oper('INS','UPD') then
        l_passed := ${attribute} ${operator} ${value.minimum} and ${value.maximum}
        if not l_passed then
            l_error_stack := l_error_stack || '${attribute} must be ${operator} ${value.minimum} and ${value.maximum}.'
        end if;
    end if;
end;