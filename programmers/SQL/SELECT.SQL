
-- 평균 일일 대여 요금 구하기
SELECT ROUND(AVG(DAILY_FEE)) AS AVERAGE_FEE
FROM CAR_RENTAL_COMPANY_CAR
WHERE CAR_TYPE = 'SUV'

-- 과일로 만든 아이스크림 고르기
SELECT A.FLAVOR
FROM FIRST_HALF AS A
JOIN ICECREAM_INFO AS B ON A.FLAVOR = B.FLAVOR
WHERE A.TOTAL_ORDER > 3000 AND B.INGREDIENT_TYPE = 'fruit_based'
ORDER BY A.TOTAL_ORDER DESC;

-- 재구매가 일어난 상품과 회원 리스트 구하기
SELECT USER_ID, PRODUCT_ID 
FROM ONLINE_SALE 
GROUP BY USER_ID, PRODUCT_ID
HAVING COUNT(SALES_AMOUNT) > 1
ORDER BY USER_ID ASC, PRODUCT_ID DESC

-- 3월에 태어난 여성 회원 목록 출력
SELECT MEMBER_ID, MEMBER_NAME, GENDER, DATE_FORMAT(DATE_OF_BIRTH, '%Y-%m-%d') DATE_OF_BIRTH
FROM MEMBER_PROFILE
WHERE GENDER = 'W' AND MONTH(DATE_OF_BIRTH)=3 AND TLNO IS NOT NULL
ORDER BY MEMBER_ID;

-- 서울에 위치한 식당 목록 출력하기
SELECT 
    A.REST_ID, 
    B.REST_NAME, 
    B.FOOD_TYPE, 
    B.FAVORITES, 
    B.ADDRESS, 
    ROUND(AVG(A.REVIEW_SCORE),2) AS SCORE 
FROM REST_REVIEW AS A
JOIN REST_INFO AS B ON A.REST_ID = B.REST_ID
WHERE B.ADDRESS LIKE '서울%'
GROUP BY A.REST_ID
ORDER BY SCORE DESC, B.FAVORITES DESC

-- 흉부외과 또는 일반외과 의사 목록 출력하기
SELECT DR_NAME, DR_ID, MCDP_CD, DATE_FORMAT(HIRE_YMD, '%Y-%m-%d') HIRE_YMD
FROM DOCTOR
WHERE MCDP_CD = 'CS' OR MCDP_CD = 'GS'
ORDER BY HIRE_YMD DESC, DR_NAME

-- 인기있는 아이스크림
SELECT FLAVOR 
FROM FIRST_HALF
ORDER BY TOTAL_ORDER DESC, SHIPMENT_ID 