SELECT concat('/home/grep/src/',board_id,'/',file_id,file_name,file_ext) as FILE_PATH
FROM used_goods_file
WHERE board_id = (SELECT board_id 
                   FROM USED_GOODS_BOARD
                   ORDER BY views desc
                  LIMIT 1)
ORDER BY file_id DESC;
