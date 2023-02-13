# RDBMS vs NoSQL
RDBMS
- 高度组织化结构化数据
- 结构化查询语言（SQL） (SQL)
- 数据和关系都存储在单独的表中。
- 数据操纵语言，数据定义语言
- 严格的一致性
- 基础事务

NoSQL
- 代表着不仅仅是SQL
- 没有声明性查询语言
- 没有预定义的模式
-键 - 值对存储，列存储，文档存储，图形数据库
- 最终一致性，而非ACID属性
- 非结构化和不可预知的数据
- CAP定理
- 高性能，高可用性和可伸缩性

# CAP 定理（CAP theorem）
在计算机科学中, CAP定理（CAP theorem）, 又被称作 布鲁尔定理（Brewer's theorem）, 它指出对于一个分布式计算系统来说，不可能同时满足以下三点:
- 一致性 (Consistency) (所有节点在同一时间具有相同的数据)
- 可用性 (Availability) (保证每个请求不管成功或者失败都有响应)
- 分区容错性(Partition tolerance) (系统中任意信息的丢失或失败不会影响系统的继续运作)
CAP理论的核心是：一个分布式系统不可能同时很好的满足一致性，可用性和分区容错性这三个需求，最多只能同时较好的满足两个。
因此，根据 CAP 原理将 NoSQL 数据库分成了满足 CA 原则、满足 CP 原则和满足 AP 原则三 大类：
CA - 单点集群，满足一致性，可用性的系统，通常在可扩展性上不太强大。
CP - 满足一致性，分区容忍性的系统，通常性能不是特别高。
AP - 满足可用性，分区容忍性的系统，通常可能对一致性要求低一些。

# BASE
BASE：Basically Available, Soft-state, Eventually Consistent。 由 Eric Brewer 定义。

CAP理论的核心是：一个分布式系统不可能同时很好的满足一致性，可用性和分区容错性这三个需求，最多只能同时较好的满足两个。

BASE是NoSQL数据库通常对可用性及一致性的弱要求原则:

Basically Available --基本可用
Soft-state --软状态/柔性事务。 "Soft state" 可以理解为"无连接"的, 而 "Hard state" 是"面向连接"的
Eventually Consistency -- 最终一致性，也是 ACID 的最终目的。

# NoSQL 类型
<table><tbody><tr><td>类型</td><td>部分代表</td><td>特点</td></tr><tr><td>列存储</td><td><p><span>Hbase</span><span></span></p><p><span>Cassandra</span><span></span></p><p><span>Hypertable</span><span></span></p></td><td><p><span>顾名思义，是按列存储数据的。最大的特点是方便存储结构化和半结构化数据，方便做数据压缩，对针对某一列或者某几列的查询有非常大的 IO 优势。</span><span></span></p></td></tr><tr><td><p><span>文档存储</span><span></span></p></td><td><p><span>MongoDB</span><span></span></p><p><span>CouchDB</span><span></span></p></td><td><p><span>文档存储一般用类似 json 的格式存储，存储的内容是文档型的。这样也就有机会对某些字段建立索引，实现关系数据库的某些功能。</span><span></span></p></td></tr><tr><td><p><span>key-value 存储</span><span></span></p></td><td><p><span>Tokyo&nbsp;Cabinet&nbsp;/&nbsp;Tyrant</span><span></span></p><p><span>Berkeley&nbsp;DB</span><span></span></p><p><span>MemcacheDB</span><span></span></p><p><span>Redis</span><span></span></p></td><td><p><span>可以通过 key 快速查询到其 value。一般来说，存储不管 value 的格式，照单全收。（Redis 包含了其他功能）</span><span></span></p></td></tr><tr><td><p><span>图存储</span><span></span></p></td><td><p><span>Neo4J</span><span></span></p><p><span>FlockDB</span><span></span></p></td><td><p><span>图形关系的最佳存储。使用传统关系数据库来解决的话性能低下，而且设计使用不方便。</span><span></span></p></td></tr><tr><td><p><span>对象存储</span><span></span></p></td><td><p><span>db4o</span><span></span></p><p><span>Versant</span><span></span></p></td><td><p><span>通过类似面向对象语言的语法操作数据库，通过对象的方式存取数据。</span><span></span></p></td></tr><tr><td><p><span>xml 数据库</span><span></span></p></td><td><p><span>Berkeley&nbsp;DB&nbsp;XML</span><span></span></p><p><span>BaseX</span><span></span></p></td><td><p><span>高效的存储 XML 数据，并支持 XML 的内部查询语法，比如 XQuery,Xpath。</span><span></span></p></td></tr></tbody></table>  

