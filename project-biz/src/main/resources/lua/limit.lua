-- 获取redis键
local key = KEYS[1]
-- 获取第一个参数（次数）
local count = tonumber(ARGV[1])
-- 获取第二个参数（时间）
local time = tonumber(ARGV[2])
-- 获取当前流量
local current = redis.call('get', key);
-- 如果current值存在，且值大于规定的次数，则拒绝放行（直接返回当前流量）
if current and tonumber(current) > count then
    return tonumber(current)
end
-- 如果值小于规定次数，或值不存在，则允许放行，当前流量数+1  (值不存在情况下，可以自增变为1)
current = redis.call('incr', key);
-- 如果是第一次进来，那么开始设置键的过期时间。
if tonumber(current) == 1 then
    redis.call('expire', key, time);
end
-- 返回当前流量
return tonumber(current)
