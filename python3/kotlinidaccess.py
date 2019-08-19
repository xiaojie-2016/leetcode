import os
import unittest


class MyTestCase(unittest.TestCase):
    def test_something(self):

        # 找出目录下所有文件
        file_list = self.list_dir(
            '/Users/xuxiaojie/WorkSpace/AndroidProjects/sunpeople-android/app/src/main/java/com/suncity/sunpeople')

        # 找出所有 xml 布局
        layout_list = self.layout_dir(
            '/Users/xuxiaojie/WorkSpace/AndroidProjects/sunpeople-android/app/src/main/res/layout')

        # 找出文件与布局对应关系
        file_map = self.find_layout_id(file_list, layout_list)
        for file, ids in file_map.items():
            with open(file, 'r+', encoding='utf-8') as f:
                new_text = ''
                for line in f:
                    for view_id in ids:
                        line = line.replace('{}.'.format(view_id), '{}?.'.format(view_id))
                    new_text += line
                f.seek(0)
                f.truncate()
                f.write(new_text)
                f.flush()
            print(file)
            print(ids)

    def find_layout_id(self, file_list, layout_list):
        file_map = {}
        for item in file_list:
            # 找出文件下所有布局
            layout_group = self.findLayoutId(item, layout_list)
            # print(item)
            # print(layout_group)
            layout_ids = []
            if len(layout_group) > 0:
                for layout in layout_group:
                    with open(layout) as layout_file:
                        for line in layout_file:
                            if line.strip().startswith('android:id'):
                                layout_ids.append(line[line.index('/') + 1:-2])
                file_map[item] = layout_ids
                # print('{}\n{}'.format(item, layout_ids))
        return file_map

    def list_dir(self, file_dir) -> list:
        """
        找出文件夹下的文件
        """
        dir_list = os.listdir(file_dir)
        file_list = []
        for cur_file in dir_list:
            file_path = os.path.join(file_dir, cur_file)
            if os.path.isfile(file_path):
                file_list.append(file_path)
            elif os.path.isdir(file_path):
                file_list.extend(self.list_dir(file_path))
        return file_list

    def layout_dir(self, layout_dir):
        dir_list = os.listdir(layout_dir)
        file_list = []
        for cur_file in dir_list:
            file_path = os.path.join(layout_dir, cur_file)
            if os.path.isfile(file_path):
                file_list.append('{}'.format(file_path))
            elif os.path.isdir(file_path):
                file_list.extend(self.layout_dir(file_path))
        return file_list

    def findLayoutId(self, file_path, layout_dir):
        """
        找出类中用到的 IDAccess
        """
        layout_list = []
        try:
            with open(file_path, encoding='utf-8') as f:
                for line in f:
                    if line.__contains__('{'):
                        return layout_list
                    if line.startswith('import kotlinx'):
                        for layout in layout_dir:
                            if layout.__contains__(line.split('.')[4]):
                                layout_list.append(layout)
        except UnicodeDecodeError:
            print('errFile {}'.format(file_path))
        return layout_list


if __name__ == '__main__':
    unittest.main()
