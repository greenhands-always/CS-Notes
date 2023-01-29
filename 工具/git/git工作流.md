
# 基本工作流
一般本地工作流程如下：
- 克隆 Git 资源作为工作目录。
- 在克隆的资源上添加或修改文件。
- 如果其他人修改了，你可以更新资源。`git pull`
- 在提交前查看修改。
- 提交修改。
- 在修改完成后，如果发现错误，可以撤回提交并再次修改并提交。
工作流:
![](https://obsidian-notes-of-huangyh.oss-cn-hangzhou.aliyuncs.com/img/20230129161453.png)

> 
> | 命令            | 功能                         |     |
> | --------------- | ---------------------------- | --- |
> | `git clone xxx` | 克隆 Git 资源作为工作目录    |     |
> | `git status`    | 查看仓库状态                 |     |
> | `git add .`     | 保存所有更改至暂存区;        |     |
> | `git diff`      | 比较暂存区和工作区差异       |     |
> | `git commit`    | 把所有暂存区内容添加到仓库中 |     |
> |                 |                              |     |

与 remote 通信的工作流
![](https://obsidian-notes-of-huangyh.oss-cn-hangzhou.aliyuncs.com/img/20230129161740.png)
