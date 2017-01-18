
--evaluate business rule ${name}
declare
    l_passed    boolean := true;
begin
    if l_oper('INS','UPD') then
        l_passed := ${attribute} ${operator} ${value.compare};
        if not l_passed then
            l_error_stack := l_error_stack || '${attribute} must be ${operator} to ${value.compare}.';
        end if;
    end if;
end;