package sbrf.hackaton.cit.srv.data;

import java.util.List;

//{"traffic":[
//        {"a": 0, "b": 1, "jam": "1.46"}, {"a": 0, "b": 3, "jam": "1.34"}, {"a": 0, "b": 5, "jam": "1.45"}, {"a": 0, "b": 6, "jam": "1.24"}, {"a": 0, "b": 4, "jam": "1.33"},{"a": 0, "b": 8, "jam": "1.99"}, {"a": 0, "b": 9, "jam": "1.20"}, {"a": 0, "b": 10, "jam": "1.76"}, {"a": 0, "b": 2, "jam": "1.64"}, {"a": 0, "b": 11, "jam": "1.35"},{"a": 0, "b": 12, "jam": "1.98"}, {"a": 0, "b": 7, "jam": "1.67"}, {"a": 0, "b": 14, "jam": "1.65"}, {"a": 0, "b": 13, "jam": "1.99"}, {"a": 0, "b": 17, "jam": "1.17"},{"a": 0, "b": 15, "jam": "1.24"}, {"a": 0, "b": 19, "jam": "1.27"}, {"a": 0, "b": 20, "jam": "1.35"}, {"a": 0, "b": 16, "jam": "1.57"}, {"a": 0, "b": 22, "jam": "1.34"},{"a": 0, "b": 21, "jam": "1.58"}, {"a": 0, "b": 18, "jam": "1.65"}, {"a": 0, "b": 24, "jam": "2.00"}, {"a": 0, "b": 23, "jam": "1.40"}, {"a": 0, "b": 26, "jam": "1.90"},{"a": 0, "b": 28, "jam": "1.38"}, {"a": 0, "b": 25, "jam": "1.60"}, {"a": 0, "b": 29, "jam": "1.42"}, {"a": 0, "b": 27, "jam": "1.21"}, {"a": 0, "b": 30, "jam": "1.94"},{"a": 0, "b": 32, "jam": "1.78"}, {"a": 0, "b": 31, "jam": "1.89"}, {"a": 0, "b": 33, "jam": "1.63"}, {"a": 0, "b": 35, "jam": "1.85"}, {"a": 0, "b": 36, "jam": "1.59"},{"a": 0, "b": 38, "jam": "1.10"}, {"a": 0, "b": 39, "jam": "1.65"}, {"a": 0, "b": 40, "jam": "1.93"}, {"a": 0, "b": 37, "jam": "1.60"}, {"a": 1, "b": 2, "jam": "1.37"},{"a": 0, "b": 34, "jam": "1.70"}, {"a": 1, "b": 3, "jam": "1.99"}, {"a": 1, "b": 5, "jam": "1.29"}, {"a": 1, "b": 6, "jam": "1.73"}, {"a": 1, "b": 7, "jam": "1.53"},{"a": 1, "b": 4, "jam": "1.23"}, {"a": 1, "b": 8, "jam": "1.26"}, {"a": 1, "b": 12, "jam": "1.42"}, {"a": 1, "b": 11, "jam": "1.72"}, {"a": 1, "b": 13, "jam": "1.81"},{"a": 1, "b": 16, "jam": "1.54"}, {"a": 1, "b": 14, "jam": "1.54"}, {"a": 1, "b": 10, "jam": "1.50"}, {"a": 1, "b": 9, "jam": "1.60"}, {"a": 1, "b": 18, "jam": "1.48"},{"a": 1, "b": 15, "jam": "1.53"}, {"a": 1, "b": 17, "jam": "1.16"}, {"a": 1, "b": 20, "jam": "1.87"}, {"a": 1, "b": 23, "jam": "1.53"}, {"a": 1, "b": 21, "jam": "1.07"},{"a": 1, "b": 22, "jam": "1.86"}, {"a": 1, "b": 24, "jam": "1.62"}, {"a": 1, "b": 19, "jam": "1.80"}, {"a": 1, "b": 29, "jam": "1.79"}, {"a": 1, "b": 28, "jam": "1.44"},{"a": 1, "b": 25, "jam": "1.13"}, {"a": 1, "b": 26, "jam": "1.08"}, {"a": 1, "b": 27, "jam": "1.47"}, {"a": 1, "b": 31, "jam": "1.82"}, {"a": 1, "b": 30, "jam": "1.87"},{"a": 1, "b": 33, "jam": "1.88"}, {"a": 1, "b": 34, "jam": "1.96"}, {"a": 1, "b": 35, "jam": "1.89"}, {"a": 1, "b": 40, "jam": "1.19"}, {"a": 1, "b": 36, "jam": "1.03"},{"a": 1, "b": 32, "jam": "1.72"}, {"a": 1, "b": 38, "jam": "1.74"}, {"a": 1, "b": 37, "jam": "1.25"}, {"a": 2, "b": 5, "jam": "1.29"}, {"a": 2, "b": 4, "jam": "1.95"},{"a": 2, "b": 3, "jam": "1.93"}, {"a": 2, "b": 6, "jam": "1.65"}, {"a": 2, "b": 9, "jam": "1.48"}, {"a": 2, "b": 10, "jam": "1.91"}, {"a": 2, "b": 7, "jam": "1.47"},{"a": 1, "b": 39, "jam": "1.71"}, {"a": 2, "b": 14, "jam": "1.72"}, {"a": 2, "b": 12, "jam": "1.84"}, {"a": 2, "b": 13, "jam": "1.64"}, {"a": 2, "b": 8, "jam": "1.70"},{"a": 2, "b": 15, "jam": "1.39"}, {"a": 2, "b": 16, "jam": "1.72"}, {"a": 2, "b": 11, "jam": "1.83"}, {"a": 2, "b": 19, "jam": "1.19"}, {"a": 2, "b": 20, "jam": "1.08"},{"a": 2, "b": 17, "jam": "1.75"}, {"a": 2, "b": 18, "jam": "1.02"}, {"a": 2, "b": 23, "jam": "1.81"}, {"a": 2, "b": 24, "jam": "1.94"}, {"a": 2, "b": 25, "jam": "1.88"},{"a": 2, "b": 22, "jam": "1.39"}, {"a": 2, "b": 26, "jam": "1.66"}, {"a": 2, "b": 21, "jam": "1.93"}, {"a": 2, "b": 27, "jam": "1.02"}, {"a": 2, "b": 30, "jam": "1.25"},{"a": 2, "b": 29, "jam": "1.18"}, {"a": 2, "b": 28, "jam": "1.76"}, {"a": 2, "b": 31, "jam": "1.02"}, {"a": 2, "b": 32, "jam": "1.35"}, {"a": 2, "b": 36, "jam": "1.10"},{"a": 2, "b": 34, "jam": "1.10"}, {"a": 2, "b": 35, "jam": "1.63"}, {"a": 2, "b": 37, "jam": "1.20"}, {"a": 2, "b": 33, "jam": "1.48"}, {"a": 3, "b": 4, "jam": "1.91"},{"a": 2, "b": 38, "jam": "1.53"}, {"a": 3, "b": 5, "jam": "1.48"}, {"a": 2, "b": 40, "jam": "1.64"}, {"a": 2, "b": 39, "jam": "1.43"}, {"a": 3, "b": 6, "jam": "1.95"},{"a": 3, "b": 7, "jam": "1.48"}, {"a": 3, "b": 9, "jam": "1.13"}, {"a": 3, "b": 8, "jam": "1.03"}, {"a": 3, "b": 10, "jam": "1.08"}, {"a": 3, "b": 12, "jam": "1.94"},{"a": 3, "b": 11, "jam": "1.18"}, {"a": 3, "b": 13, "jam": "1.75"}, {"a": 3, "b": 15, "jam": "1.97"}, {"a": 3, "b": 14, "jam": "1.32"}, {"a": 3, "b": 19, "jam": "1.70"},{"a": 3, "b": 18, "jam": "1.61"}, {"a": 3, "b": 16, "jam": "1.36"}, {"a": 3, "b": 17, "jam": "1.37"}, {"a": 3, "b": 22, "jam": "1.30"}, {"a": 3, "b": 20, "jam": "1.91"},{"a": 3, "b": 21, "jam": "1.10"}, {"a": 3, "b": 23, "jam": "1.61"}, {"a": 3, "b": 24, "jam": "1.72"}, {"a": 3, "b": 25, "jam": "1.07"}, {"a": 3, "b": 29, "jam": "1.84"},{"a": 3, "b": 27, "jam": "1.89"}, {"a": 3, "b": 30, "jam": "1.02"}, {"a": 3, "b": 28, "jam": "1.69"}, {"a": 3, "b": 26, "jam": "1.99"}, {"a": 3, "b": 34, "jam": "1.35"},{"a": 3, "b": 33, "jam": "1.24"}, {"a": 3, "b": 35, "jam": "1.35"}, {"a": 3, "b": 32, "jam": "1.50"}, {"a": 3, "b": 31, "jam": "1.33"}, {"a": 3, "b": 36, "jam": "1.21"},{"a": 3, "b": 38, "jam": "1.63"}, {"a": 3, "b": 40, "jam": "1.33"}, {"a": 3, "b": 37, "jam": "1.64"}, {"a": 3, "b": 39, "jam": "1.67"}, {"a": 4, "b": 7, "jam": "1.33"},{"a": 4, "b": 6, "jam": "1.08"}, {"a": 4, "b": 8, "jam": "1.91"}, {"a": 4, "b": 5, "jam": "1.33"}, {"a": 4, "b": 10, "jam": "1.30"}, {"a": 4, "b": 9, "jam": "1.25"},{"a": 4, "b": 11, "jam": "1.09"}, {"a": 4, "b": 13, "jam": "1.29"}, {"a": 4, "b": 12, "jam": "1.64"}, {"a": 4, "b": 15, "jam": "1.31"}, {"a": 4, "b": 14, "jam": "1.39"},{"a": 4, "b": 16, "jam": "1.16"}, {"a": 4, "b": 17, "jam": "1.43"}, {"a": 4, "b": 19, "jam": "1.57"}, {"a": 4, "b": 18, "jam": "1.64"}, {"a": 4, "b": 20, "jam": "1.38"},{"a": 4, "b": 21, "jam": "1.81"}, {"a": 4, "b": 22, "jam": "1.81"}, {"a": 4, "b": 23, "jam": "1.23"}, {"a": 4, "b": 24, "jam": "1.01"}, {"a": 4, "b": 25, "jam": "1.33"},{"a": 4, "b": 26, "jam": "1.34"}, {"a": 4, "b": 27, "jam": "1.57"}, {"a": 4, "b": 28, "jam": "1.42"}, {"a": 4, "b": 29, "jam": "1.56"}, {"a": 4, "b": 30, "jam": "1.39"},{"a": 4, "b": 31, "jam": "1.64"}, {"a": 4, "b": 32, "jam": "1.25"}, {"a": 4, "b": 33, "jam": "1.06"}, {"a": 4, "b": 35, "jam": "1.94"}, {"a": 4, "b": 36, "jam": "1.23"},{"a": 4, "b": 34, "jam": "1.43"}, {"a": 4, "b": 38, "jam": "1.58"}, {"a": 4, "b": 37, "jam": "1.55"}, {"a": 5, "b": 6, "jam": "1.22"}, {"a": 4, "b": 39, "jam": "1.89"},{"a": 5, "b": 7, "jam": "1.94"}, {"a": 4, "b": 40, "jam": "1.42"}, {"a": 5, "b": 10, "jam": "1.98"}, {"a": 5, "b": 8, "jam": "1.96"}, {"a": 5, "b": 9, "jam": "1.71"},{"a": 5, "b": 11, "jam": "1.85"}, {"a": 5, "b": 12, "jam": "1.99"}, {"a": 5, "b": 13, "jam": "1.07"}, {"a": 5, "b": 14, "jam": "1.02"}, {"a": 5, "b": 15, "jam": "1.39"},{"a": 5, "b": 17, "jam": "1.76"}, {"a": 5, "b": 18, "jam": "1.57"}, {"a": 5, "b": 16, "jam": "1.42"}, {"a": 5, "b": 19, "jam": "1.75"}, {"a": 5, "b": 20, "jam": "1.20"},{"a": 5, "b": 21, "jam": "1.58"}, {"a": 5, "b": 22, "jam": "1.14"}, {"a": 5, "b": 23, "jam": "1.88"}, {"a": 5, "b": 24, "jam": "1.17"}, {"a": 5, "b": 25, "jam": "1.47"},{"a": 5, "b": 26, "jam": "1.43"}, {"a": 5, "b": 27, "jam": "1.60"}, {"a": 5, "b": 28, "jam": "1.09"}, {"a": 5, "b": 30, "jam": "1.19"}, {"a": 5, "b": 29, "jam": "1.40"},{"a": 5, "b": 31, "jam": "1.20"}, {"a": 5, "b": 32, "jam": "1.53"}, {"a": 5, "b": 33, "jam": "1.06"}, {"a": 5, "b": 34, "jam": "1.24"}, {"a": 5, "b": 35, "jam": "1.87"},{"a": 5, "b": 36, "jam": "1.97"}, {"a": 5, "b": 38, "jam": "1.21"}, {"a": 5, "b": 37, "jam": "1.05"}, {"a": 5, "b": 39, "jam": "1.29"}, {"a": 5, "b": 40, "jam": "1.79"},{"a": 6, "b": 7, "jam": "1.24"}, {"a": 6, "b": 9, "jam": "1.15"}, {"a": 6, "b": 8, "jam": "2.00"}, {"a": 6, "b": 10, "jam": "1.51"}, {"a": 6, "b": 12, "jam": "1.92"},{"a": 6, "b": 11, "jam": "1.03"}, {"a": 6, "b": 13, "jam": "1.49"}, {"a": 6, "b": 14, "jam": "1.37"}, {"a": 6, "b": 15, "jam": "1.06"}, {"a": 6, "b": 16, "jam": "1.09"},{"a": 6, "b": 17, "jam": "1.98"}, {"a": 6, "b": 18, "jam": "1.84"}, {"a": 6, "b": 19, "jam": "1.98"}, {"a": 6, "b": 21, "jam": "1.93"}, {"a": 6, "b": 20, "jam": "1.76"},{"a": 6, "b": 22, "jam": "1.55"}, {"a": 6, "b": 23, "jam": "1.01"}, {"a": 6, "b": 24, "jam": "1.63"}, {"a": 6, "b": 25, "jam": "1.07"}, {"a": 6, "b": 26, "jam": "1.08"},{"a": 6, "b": 27, "jam": "1.64"}, {"a": 6, "b": 28, "jam": "1.38"}, {"a": 6, "b": 29, "jam": "1.29"}, {"a": 6, "b": 30, "jam": "1.57"}, {"a": 6, "b": 31, "jam": "1.45"},{"a": 6, "b": 33, "jam": "1.49"}, {"a": 6, "b": 32, "jam": "1.45"}, {"a": 6, "b": 34, "jam": "1.83"}, {"a": 6, "b": 35, "jam": "1.84"}, {"a": 6, "b": 36, "jam": "1.70"},{"a": 6, "b": 39, "jam": "1.66"}, {"a": 6, "b": 37, "jam": "1.79"}, {"a": 6, "b": 38, "jam": "1.68"}, {"a": 6, "b": 40, "jam": "1.21"}, {"a": 7, "b": 9, "jam": "1.94"},{"a": 7, "b": 8, "jam": "1.35"}, {"a": 7, "b": 10, "jam": "1.46"}, {"a": 7, "b": 11, "jam": "1.54"}, {"a": 7, "b": 13, "jam": "1.15"}, {"a": 7, "b": 12, "jam": "1.18"},{"a": 7, "b": 15, "jam": "1.46"}, {"a": 7, "b": 14, "jam": "1.43"}, {"a": 7, "b": 16, "jam": "1.19"}, {"a": 7, "b": 17, "jam": "1.29"}, {"a": 7, "b": 20, "jam": "1.99"},{"a": 7, "b": 18, "jam": "1.23"}, {"a": 7, "b": 19, "jam": "1.03"}, {"a": 7, "b": 23, "jam": "1.33"}, {"a": 7, "b": 21, "jam": "1.56"}, {"a": 7, "b": 22, "jam": "1.01"},{"a": 7, "b": 24, "jam": "1.07"}, {"a": 7, "b": 25, "jam": "1.86"}, {"a": 7, "b": 26, "jam": "1.37"}, {"a": 7, "b": 27, "jam": "1.27"}, {"a": 7, "b": 28, "jam": "1.17"},{"a": 7, "b": 29, "jam": "1.16"}, {"a": 7, "b": 30, "jam": "1.41"}, {"a": 7, "b": 33, "jam": "1.89"}, {"a": 7, "b": 31, "jam": "1.76"}, {"a": 7, "b": 32, "jam": "1.42"},{"a": 7, "b": 36, "jam": "1.21"}, {"a": 7, "b": 34, "jam": "1.48"}, {"a": 7, "b": 35, "jam": "1.56"}, {"a": 7, "b": 38, "jam": "1.85"}, {"a": 7, "b": 37, "jam": "1.77"},{"a": 7, "b": 39, "jam": "1.75"}, {"a": 8, "b": 9, "jam": "1.26"}, {"a": 7, "b": 40, "jam": "1.30"}, {"a": 8, "b": 11, "jam": "1.32"}, {"a": 8, "b": 10, "jam": "1.50"},{"a": 8, "b": 12, "jam": "1.28"}, {"a": 8, "b": 15, "jam": "1.01"}, {"a": 8, "b": 13, "jam": "1.98"}, {"a": 8, "b": 14, "jam": "1.55"}, {"a": 8, "b": 17, "jam": "1.52"},{"a": 8, "b": 16, "jam": "1.13"}, {"a": 8, "b": 18, "jam": "1.11"}, {"a": 8, "b": 19, "jam": "1.81"}, {"a": 8, "b": 20, "jam": "1.71"}, {"a": 8, "b": 22, "jam": "1.85"},{"a": 8, "b": 21, "jam": "1.82"}, {"a": 8, "b": 24, "jam": "1.16"}, {"a": 8, "b": 25, "jam": "1.71"}, {"a": 8, "b": 23, "jam": "1.28"}, {"a": 8, "b": 27, "jam": "1.49"},{"a": 8, "b": 26, "jam": "1.47"}, {"a": 8, "b": 28, "jam": "1.18"}, {"a": 8, "b": 29, "jam": "1.05"}, {"a": 8, "b": 31, "jam": "1.16"}, {"a": 8, "b": 30, "jam": "1.85"},{"a": 8, "b": 33, "jam": "1.17"}, {"a": 8, "b": 32, "jam": "1.10"}, {"a": 8, "b": 36, "jam": "1.41"}, {"a": 8, "b": 35, "jam": "1.55"}, {"a": 8, "b": 37, "jam": "1.46"},{"a": 8, "b": 38, "jam": "1.52"}, {"a": 8, "b": 34, "jam": "1.75"}, {"a": 8, "b": 39, "jam": "1.27"}, {"a": 8, "b": 40, "jam": "1.48"}, {"a": 9, "b": 10, "jam": "1.33"},{"a": 9, "b": 11, "jam": "1.28"}, {"a": 9, "b": 14, "jam": "1.46"}, {"a": 9, "b": 12, "jam": "1.23"}, {"a": 9, "b": 13, "jam": "1.72"}, {"a": 9, "b": 15, "jam": "1.43"},{"a": 9, "b": 17, "jam": "1.53"}, {"a": 9, "b": 16, "jam": "1.81"}, {"a": 9, "b": 18, "jam": "1.05"}, {"a": 9, "b": 19, "jam": "1.97"}, {"a": 9, "b": 20, "jam": "1.45"},{"a": 9, "b": 23, "jam": "1.33"}, {"a": 9, "b": 21, "jam": "1.78"}, {"a": 9, "b": 22, "jam": "1.60"}, {"a": 9, "b": 24, "jam": "1.69"}, {"a": 9, "b": 25, "jam": "1.75"},{"a": 9, "b": 26, "jam": "1.48"}, {"a": 9, "b": 28, "jam": "1.91"}, {"a": 9, "b": 29, "jam": "1.33"}, {"a": 9, "b": 27, "jam": "1.76"}, {"a": 9, "b": 30, "jam": "1.70"},{"a": 9, "b": 31, "jam": "1.51"}, {"a": 9, "b": 32, "jam": "1.56"}, {"a": 9, "b": 33, "jam": "1.57"}, {"a": 9, "b": 34, "jam": "1.14"}, {"a": 9, "b": 36, "jam": "1.78"},{"a": 9, "b": 37, "jam": "1.91"}, {"a": 9, "b": 35, "jam": "1.31"}, {"a": 9, "b": 38, "jam": "1.53"}, {"a": 9, "b": 39, "jam": "1.49"}, {"a": 9, "b": 40, "jam": "1.37"},{"a": 10, "b": 11, "jam": "1.19"}, {"a": 10, "b": 12, "jam": "1.25"}, {"a": 10, "b": 13, "jam": "1.91"}, {"a": 10, "b": 14, "jam": "1.56"}, {"a": 10, "b": 15, "jam": "1.15"},{"a": 10, "b": 16, "jam": "1.18"}, {"a": 10, "b": 17, "jam": "1.87"}, {"a": 10, "b": 19, "jam": "1.10"}, {"a": 10, "b": 18, "jam": "1.70"}, {"a": 10, "b": 20, "jam": "1.34"},{"a": 10, "b": 22, "jam": "1.48"}, {"a": 10, "b": 23, "jam": "1.23"}, {"a": 10, "b": 21, "jam": "1.88"}, {"a": 10, "b": 24, "jam": "1.08"}, {"a": 10, "b": 27, "jam": "1.45"},{"a": 10, "b": 26, "jam": "1.53"}, {"a": 10, "b": 25, "jam": "1.18"}, {"a": 10, "b": 29, "jam": "1.59"}, {"a": 10, "b": 30, "jam": "1.38"}, {"a": 10, "b": 28, "jam": "1.18"},{"a": 10, "b": 31, "jam": "1.81"}, {"a": 10, "b": 32, "jam": "1.16"}, {"a": 10, "b": 33, "jam": "1.93"}, {"a": 10, "b": 34, "jam": "1.12"}, {"a": 10, "b": 35, "jam": "1.60"},{"a": 10, "b": 36, "jam": "1.97"}, {"a": 10, "b": 37, "jam": "1.49"}, {"a": 10, "b": 38, "jam": "1.39"}, {"a": 10, "b": 39, "jam": "1.41"}, {"a": 10, "b": 40, "jam": "1.35"},{"a": 11, "b": 13, "jam": "1.55"}, {"a": 11, "b": 12, "jam": "1.42"}, {"a": 11, "b": 14, "jam": "1.56"}, {"a": 11, "b": 16, "jam": "1.09"}, {"a": 11, "b": 17, "jam": "1.58"},{"a": 11, "b": 15, "jam": "1.11"}, {"a": 11, "b": 18, "jam": "1.93"}, {"a": 11, "b": 20, "jam": "1.28"}, {"a": 11, "b": 19, "jam": "1.73"}, {"a": 11, "b": 22, "jam": "1.35"},{"a": 11, "b": 23, "jam": "1.06"}, {"a": 11, "b": 21, "jam": "1.97"}, {"a": 11, "b": 24, "jam": "1.44"}, {"a": 11, "b": 26, "jam": "1.89"}, {"a": 11, "b": 25, "jam": "1.78"},{"a": 11, "b": 27, "jam": "1.09"}, {"a": 11, "b": 29, "jam": "1.67"}, {"a": 11, "b": 28, "jam": "1.75"}, {"a": 11, "b": 30, "jam": "1.62"}, {"a": 11, "b": 31, "jam": "1.39"},{"a": 11, "b": 32, "jam": "1.73"}, {"a": 11, "b": 34, "jam": "1.28"}, {"a": 11, "b": 33, "jam": "1.64"}, {"a": 11, "b": 35, "jam": "1.23"}, {"a": 11, "b": 37, "jam": "1.77"},{"a": 11, "b": 38, "jam": "1.24"}, {"a": 11, "b": 36, "jam": "1.07"}, {"a": 12, "b": 13, "jam": "2.00"}, {"a": 11, "b": 39, "jam": "1.08"}, {"a": 11, "b": 40, "jam": "1.07"},{"a": 12, "b": 14, "jam": "1.31"}, {"a": 12, "b": 15, "jam": "1.69"}, {"a": 12, "b": 17, "jam": "1.92"}, {"a": 12, "b": 16, "jam": "1.47"}, {"a": 12, "b": 18, "jam": "1.10"},{"a": 12, "b": 19, "jam": "1.76"}, {"a": 12, "b": 20, "jam": "1.37"}, {"a": 12, "b": 21, "jam": "1.37"}, {"a": 12, "b": 22, "jam": "1.49"}, {"a": 12, "b": 23, "jam": "1.42"},{"a": 12, "b": 24, "jam": "1.88"}, {"a": 12, "b": 25, "jam": "1.99"}, {"a": 12, "b": 26, "jam": "1.57"}, {"a": 12, "b": 27, "jam": "1.19"}, {"a": 12, "b": 28, "jam": "1.32"},{"a": 12, "b": 29, "jam": "1.15"}, {"a": 12, "b": 30, "jam": "1.41"}, {"a": 12, "b": 32, "jam": "1.43"}, {"a": 12, "b": 31, "jam": "1.45"}, {"a": 12, "b": 34, "jam": "1.59"},{"a": 12, "b": 33, "jam": "1.02"}, {"a": 12, "b": 35, "jam": "1.36"}, {"a": 12, "b": 36, "jam": "1.66"}, {"a": 12, "b": 37, "jam": "1.75"}, {"a": 12, "b": 39, "jam": "1.19"},{"a": 12, "b": 38, "jam": "1.94"}, {"a": 13, "b": 15, "jam": "1.96"}, {"a": 12, "b": 40, "jam": "1.37"}, {"a": 13, "b": 14, "jam": "1.24"}, {"a": 13, "b": 16, "jam": "1.54"},{"a": 13, "b": 17, "jam": "1.56"}, {"a": 13, "b": 18, "jam": "1.83"}, {"a": 13, "b": 19, "jam": "1.11"}, {"a": 13, "b": 20, "jam": "1.61"}, {"a": 13, "b": 21, "jam": "1.69"},{"a": 13, "b": 22, "jam": "1.27"}, {"a": 13, "b": 23, "jam": "1.25"}, {"a": 13, "b": 24, "jam": "1.44"}, {"a": 13, "b": 26, "jam": "1.79"}, {"a": 13, "b": 27, "jam": "1.06"},{"a": 13, "b": 25, "jam": "1.98"}, {"a": 13, "b": 29, "jam": "1.36"}, {"a": 13, "b": 28, "jam": "1.36"}, {"a": 13, "b": 30, "jam": "1.79"}, {"a": 13, "b": 32, "jam": "1.85"},{"a": 13, "b": 33, "jam": "1.76"}, {"a": 13, "b": 31, "jam": "1.37"}, {"a": 13, "b": 34, "jam": "1.18"}, {"a": 13, "b": 35, "jam": "1.29"}, {"a": 13, "b": 37, "jam": "1.12"},{"a": 13, "b": 38, "jam": "1.44"}, {"a": 13, "b": 36, "jam": "1.46"}, {"a": 13, "b": 39, "jam": "1.14"}, {"a": 13, "b": 40, "jam": "1.96"}, {"a": 14, "b": 15, "jam": "1.29"},{"a": 14, "b": 18, "jam": "1.86"}, {"a": 14, "b": 16, "jam": "1.40"}, {"a": 14, "b": 17, "jam": "1.08"}, {"a": 14, "b": 20, "jam": "1.97"}, {"a": 14, "b": 19, "jam": "1.59"},{"a": 14, "b": 22, "jam": "1.79"}, {"a": 14, "b": 23, "jam": "1.99"}, {"a": 14, "b": 21, "jam": "1.71"}, {"a": 14, "b": 24, "jam": "1.29"}, {"a": 14, "b": 25, "jam": "1.80"},{"a": 14, "b": 26, "jam": "1.99"}, {"a": 14, "b": 28, "jam": "1.02"}, {"a": 14, "b": 27, "jam": "1.93"}, {"a": 14, "b": 30, "jam": "1.26"}, {"a": 14, "b": 29, "jam": "1.88"},{"a": 14, "b": 32, "jam": "1.93"}, {"a": 14, "b": 33, "jam": "1.29"}, {"a": 14, "b": 31, "jam": "1.48"}, {"a": 14, "b": 34, "jam": "1.46"}, {"a": 14, "b": 36, "jam": "1.61"},{"a": 14, "b": 35, "jam": "1.59"}, {"a": 14, "b": 38, "jam": "1.91"}, {"a": 14, "b": 39, "jam": "1.71"}, {"a": 15, "b": 16, "jam": "1.63"}, {"a": 14, "b": 40, "jam": "1.07"},{"a": 15, "b": 17, "jam": "1.34"}, {"a": 14, "b": 37, "jam": "1.54"}, {"a": 15, "b": 18, "jam": "1.55"}, {"a": 15, "b": 20, "jam": "1.68"}, {"a": 15, "b": 19, "jam": "1.16"},{"a": 15, "b": 21, "jam": "1.77"}, {"a": 15, "b": 22, "jam": "1.61"}, {"a": 15, "b": 24, "jam": "1.53"}, {"a": 15, "b": 23, "jam": "1.48"}, {"a": 15, "b": 25, "jam": "1.76"},{"a": 15, "b": 26, "jam": "1.57"}, {"a": 15, "b": 28, "jam": "1.14"}, {"a": 15, "b": 27, "jam": "1.08"}, {"a": 15, "b": 29, "jam": "1.89"}, {"a": 15, "b": 30, "jam": "1.50"},{"a": 15, "b": 32, "jam": "1.20"}, {"a": 15, "b": 31, "jam": "1.95"}, {"a": 15, "b": 33, "jam": "1.04"}, {"a": 15, "b": 35, "jam": "1.62"}, {"a": 15, "b": 34, "jam": "1.80"},{"a": 15, "b": 36, "jam": "1.50"}, {"a": 15, "b": 37, "jam": "1.33"}, {"a": 15, "b": 38, "jam": "1.56"}, {"a": 15, "b": 39, "jam": "1.26"}, {"a": 15, "b": 40, "jam": "1.76"},{"a": 16, "b": 18, "jam": "1.60"}, {"a": 16, "b": 17, "jam": "1.43"}, {"a": 16, "b": 20, "jam": "1.65"}, {"a": 16, "b": 21, "jam": "1.27"}, {"a": 16, "b": 22, "jam": "1.25"},{"a": 16, "b": 24, "jam": "1.32"}, {"a": 16, "b": 23, "jam": "1.67"}, {"a": 16, "b": 19, "jam": "1.30"}, {"a": 16, "b": 25, "jam": "1.22"}, {"a": 16, "b": 27, "jam": "1.48"},{"a": 16, "b": 28, "jam": "1.07"}, {"a": 16, "b": 26, "jam": "1.91"}, {"a": 16, "b": 29, "jam": "1.13"}, {"a": 16, "b": 30, "jam": "1.21"}, {"a": 16, "b": 31, "jam": "1.56"},{"a": 16, "b": 32, "jam": "1.75"}, {"a": 16, "b": 33, "jam": "1.36"}, {"a": 16, "b": 34, "jam": "1.98"}, {"a": 16, "b": 35, "jam": "1.69"}, {"a": 16, "b": 37, "jam": "1.12"},{"a": 16, "b": 36, "jam": "1.46"}, {"a": 16, "b": 38, "jam": "1.06"}, {"a": 16, "b": 40, "jam": "1.36"}, {"a": 16, "b": 39, "jam": "1.83"}, {"a": 17, "b": 18, "jam": "1.38"},{"a": 17, "b": 19, "jam": "1.78"}, {"a": 17, "b": 22, "jam": "1.22"}, {"a": 17, "b": 21, "jam": "1.10"}, {"a": 17, "b": 20, "jam": "1.07"}, {"a": 17, "b": 24, "jam": "1.38"},{"a": 17, "b": 23, "jam": "1.96"}, {"a": 17, "b": 25, "jam": "1.39"}, {"a": 17, "b": 26, "jam": "1.57"}, {"a": 17, "b": 27, "jam": "1.74"}, {"a": 17, "b": 29, "jam": "1.75"},{"a": 17, "b": 28, "jam": "1.17"}, {"a": 17, "b": 30, "jam": "1.44"}, {"a": 17, "b": 32, "jam": "1.85"}, {"a": 17, "b": 31, "jam": "1.24"}, {"a": 17, "b": 34, "jam": "1.80"},{"a": 17, "b": 33, "jam": "1.37"}, {"a": 17, "b": 35, "jam": "1.68"}, {"a": 17, "b": 37, "jam": "1.47"}, {"a": 17, "b": 36, "jam": "1.83"}, {"a": 17, "b": 38, "jam": "1.12"},{"a": 17, "b": 39, "jam": "1.66"}, {"a": 17, "b": 40, "jam": "1.34"}, {"a": 18, "b": 19, "jam": "1.50"}, {"a": 18, "b": 21, "jam": "1.21"}, {"a": 18, "b": 20, "jam": "1.39"},{"a": 18, "b": 22, "jam": "1.08"}, {"a": 18, "b": 23, "jam": "1.86"}, {"a": 18, "b": 24, "jam": "1.31"}, {"a": 18, "b": 25, "jam": "1.68"}, {"a": 18, "b": 26, "jam": "1.89"},{"a": 18, "b": 28, "jam": "1.35"}, {"a": 18, "b": 27, "jam": "1.85"}, {"a": 18, "b": 29, "jam": "1.64"}, {"a": 18, "b": 30, "jam": "1.38"}, {"a": 18, "b": 31, "jam": "1.25"},{"a": 18, "b": 32, "jam": "1.81"}, {"a": 18, "b": 35, "jam": "1.82"}, {"a": 18, "b": 33, "jam": "1.42"}, {"a": 18, "b": 34, "jam": "1.43"}, {"a": 18, "b": 38, "jam": "1.57"},{"a": 18, "b": 36, "jam": "1.31"}, {"a": 18, "b": 37, "jam": "1.89"}, {"a": 18, "b": 39, "jam": "1.38"}, {"a": 19, "b": 20, "jam": "1.87"}, {"a": 19, "b": 21, "jam": "1.01"},{"a": 19, "b": 22, "jam": "1.88"}, {"a": 18, "b": 40, "jam": "1.25"}, {"a": 19, "b": 23, "jam": "1.70"}, {"a": 19, "b": 24, "jam": "1.81"}, {"a": 19, "b": 25, "jam": "1.07"},{"a": 19, "b": 26, "jam": "1.48"}, {"a": 19, "b": 27, "jam": "1.57"}, {"a": 19, "b": 28, "jam": "1.83"}, {"a": 19, "b": 30, "jam": "1.60"}, {"a": 19, "b": 31, "jam": "1.75"},{"a": 19, "b": 29, "jam": "1.12"}, {"a": 19, "b": 33, "jam": "1.84"}, {"a": 19, "b": 32, "jam": "1.20"}, {"a": 19, "b": 35, "jam": "1.85"}, {"a": 19, "b": 34, "jam": "1.32"},{"a": 19, "b": 36, "jam": "1.29"}, {"a": 19, "b": 37, "jam": "1.82"}, {"a": 19, "b": 38, "jam": "1.90"}, {"a": 19, "b": 39, "jam": "1.67"}, {"a": 19, "b": 40, "jam": "1.23"},{"a": 20, "b": 22, "jam": "1.84"}, {"a": 20, "b": 23, "jam": "1.02"}, {"a": 20, "b": 21, "jam": "1.74"}, {"a": 20, "b": 24, "jam": "1.69"}, {"a": 20, "b": 25, "jam": "1.67"},{"a": 20, "b": 27, "jam": "1.97"}, {"a": 20, "b": 26, "jam": "1.12"}, {"a": 20, "b": 28, "jam": "1.67"}, {"a": 20, "b": 29, "jam": "1.18"}, {"a": 20, "b": 30, "jam": "1.21"},{"a": 20, "b": 31, "jam": "1.56"}, {"a": 20, "b": 33, "jam": "1.31"}, {"a": 20, "b": 34, "jam": "1.02"}, {"a": 20, "b": 36, "jam": "1.18"}, {"a": 20, "b": 37, "jam": "1.66"},{"a": 20, "b": 38, "jam": "1.09"}, {"a": 20, "b": 32, "jam": "1.83"}, {"a": 20, "b": 35, "jam": "1.95"}, {"a": 20, "b": 39, "jam": "1.83"}, {"a": 20, "b": 40, "jam": "1.25"},{"a": 21, "b": 24, "jam": "1.31"}, {"a": 21, "b": 23, "jam": "1.46"}, {"a": 21, "b": 25, "jam": "1.53"}, {"a": 21, "b": 22, "jam": "1.79"}, {"a": 21, "b": 27, "jam": "1.29"},{"a": 21, "b": 26, "jam": "1.31"}, {"a": 21, "b": 28, "jam": "1.64"}, {"a": 21, "b": 29, "jam": "1.12"}, {"a": 21, "b": 30, "jam": "1.37"}, {"a": 21, "b": 31, "jam": "1.87"},{"a": 21, "b": 33, "jam": "1.72"}, {"a": 21, "b": 32, "jam": "1.66"}, {"a": 21, "b": 35, "jam": "1.56"}, {"a": 21, "b": 36, "jam": "1.18"}, {"a": 21, "b": 34, "jam": "1.11"},{"a": 21, "b": 37, "jam": "1.19"}, {"a": 21, "b": 38, "jam": "1.75"}, {"a": 21, "b": 39, "jam": "1.88"}, {"a": 21, "b": 40, "jam": "1.80"}, {"a": 22, "b": 24, "jam": "1.45"},{"a": 22, "b": 25, "jam": "1.66"}, {"a": 22, "b": 23, "jam": "1.65"}, {"a": 22, "b": 28, "jam": "1.83"}, {"a": 22, "b": 26, "jam": "1.23"}, {"a": 22, "b": 29, "jam": "1.91"},{"a": 22, "b": 27, "jam": "1.11"}, {"a": 22, "b": 31, "jam": "1.22"}, {"a": 22, "b": 32, "jam": "1.89"}, {"a": 22, "b": 30, "jam": "1.09"}, {"a": 22, "b": 34, "jam": "1.92"},{"a": 22, "b": 33, "jam": "1.16"}, {"a": 22, "b": 35, "jam": "1.57"}, {"a": 22, "b": 36, "jam": "1.10"}, {"a": 22, "b": 38, "jam": "1.27"}, {"a": 22, "b": 37, "jam": "1.80"},{"a": 22, "b": 40, "jam": "1.82"}, {"a": 22, "b": 39, "jam": "1.79"}, {"a": 23, "b": 26, "jam": "1.21"}, {"a": 23, "b": 24, "jam": "1.67"}, {"a": 23, "b": 25, "jam": "1.77"},{"a": 23, "b": 27, "jam": "1.23"}, {"a": 23, "b": 29, "jam": "1.34"}, {"a": 23, "b": 28, "jam": "1.91"}, {"a": 23, "b": 31, "jam": "1.17"}, {"a": 23, "b": 30, "jam": "1.14"},{"a": 23, "b": 33, "jam": "1.56"}, {"a": 23, "b": 32, "jam": "1.49"}, {"a": 23, "b": 34, "jam": "1.27"}, {"a": 23, "b": 36, "jam": "1.69"}, {"a": 23, "b": 37, "jam": "1.17"},{"a": 23, "b": 38, "jam": "1.83"}, {"a": 23, "b": 39, "jam": "1.26"}, {"a": 23, "b": 35, "jam": "1.49"}, {"a": 23, "b": 40, "jam": "1.98"}, {"a": 24, "b": 25, "jam": "1.31"},{"a": 24, "b": 26, "jam": "1.29"}, {"a": 24, "b": 27, "jam": "1.03"}, {"a": 24, "b": 28, "jam": "1.00"}, {"a": 24, "b": 30, "jam": "1.96"}, {"a": 24, "b": 29, "jam": "1.17"},{"a": 24, "b": 32, "jam": "1.83"}, {"a": 24, "b": 31, "jam": "1.94"}, {"a": 24, "b": 33, "jam": "1.82"}, {"a": 24, "b": 34, "jam": "1.48"}, {"a": 24, "b": 36, "jam": "1.21"},{"a": 24, "b": 35, "jam": "1.01"}, {"a": 24, "b": 37, "jam": "1.18"}, {"a": 24, "b": 40, "jam": "1.81"}, {"a": 24, "b": 38, "jam": "1.60"}, {"a": 24, "b": 39, "jam": "1.82"},{"a": 25, "b": 26, "jam": "1.76"}, {"a": 25, "b": 28, "jam": "1.28"}, {"a": 25, "b": 27, "jam": "1.07"}, {"a": 25, "b": 29, "jam": "1.18"}, {"a": 25, "b": 31, "jam": "1.22"},{"a": 25, "b": 30, "jam": "1.38"}, {"a": 25, "b": 32, "jam": "1.33"}, {"a": 25, "b": 34, "jam": "1.98"}, {"a": 25, "b": 33, "jam": "1.68"}, {"a": 25, "b": 36, "jam": "1.29"},{"a": 25, "b": 37, "jam": "1.68"}, {"a": 25, "b": 35, "jam": "1.99"}, {"a": 25, "b": 38, "jam": "1.37"}, {"a": 25, "b": 39, "jam": "1.70"}, {"a": 25, "b": 40, "jam": "1.99"},{"a": 26, "b": 28, "jam": "1.72"}, {"a": 26, "b": 27, "jam": "1.34"}, {"a": 26, "b": 29, "jam": "1.64"}, {"a": 26, "b": 30, "jam": "1.19"}, {"a": 26, "b": 31, "jam": "1.03"},{"a": 26, "b": 32, "jam": "1.59"}, {"a": 26, "b": 35, "jam": "1.52"}, {"a": 26, "b": 34, "jam": "1.22"}, {"a": 26, "b": 33, "jam": "1.75"}, {"a": 26, "b": 36, "jam": "1.89"},{"a": 26, "b": 37, "jam": "1.87"}, {"a": 26, "b": 38, "jam": "1.73"}, {"a": 26, "b": 40, "jam": "1.54"}, {"a": 26, "b": 39, "jam": "1.10"}, {"a": 27, "b": 30, "jam": "1.40"},{"a": 27, "b": 29, "jam": "1.44"}, {"a": 27, "b": 28, "jam": "1.73"}, {"a": 27, "b": 31, "jam": "1.03"}, {"a": 27, "b": 32, "jam": "1.51"}, {"a": 27, "b": 33, "jam": "1.34"},{"a": 27, "b": 35, "jam": "1.50"}, {"a": 27, "b": 37, "jam": "1.99"}, {"a": 27, "b": 36, "jam": "1.73"}, {"a": 27, "b": 34, "jam": "1.80"}, {"a": 27, "b": 39, "jam": "1.83"},{"a": 27, "b": 40, "jam": "1.44"}, {"a": 27, "b": 38, "jam": "1.87"}, {"a": 28, "b": 30, "jam": "1.39"}, {"a": 28, "b": 31, "jam": "1.47"}, {"a": 28, "b": 29, "jam": "1.12"},{"a": 28, "b": 32, "jam": "1.16"}, {"a": 28, "b": 33, "jam": "1.81"}, {"a": 28, "b": 34, "jam": "1.48"}, {"a": 28, "b": 35, "jam": "1.81"}, {"a": 28, "b": 36, "jam": "1.68"},{"a": 28, "b": 37, "jam": "1.70"}, {"a": 28, "b": 38, "jam": "1.64"}, {"a": 28, "b": 39, "jam": "1.05"}, {"a": 28, "b": 40, "jam": "1.34"}, {"a": 29, "b": 32, "jam": "1.52"},{"a": 29, "b": 30, "jam": "1.26"}, {"a": 29, "b": 31, "jam": "1.47"}, {"a": 29, "b": 34, "jam": "1.51"}, {"a": 29, "b": 33, "jam": "1.26"}, {"a": 29, "b": 35, "jam": "1.94"},{"a": 29, "b": 36, "jam": "1.15"}, {"a": 29, "b": 37, "jam": "1.80"}, {"a": 29, "b": 38, "jam": "1.68"}, {"a": 29, "b": 39, "jam": "1.50"}, {"a": 29, "b": 40, "jam": "1.24"},{"a": 30, "b": 32, "jam": "1.01"}, {"a": 30, "b": 31, "jam": "1.88"}, {"a": 30, "b": 33, "jam": "1.16"}, {"a": 30, "b": 34, "jam": "1.62"}, {"a": 30, "b": 36, "jam": "1.19"},{"a": 30, "b": 35, "jam": "1.86"}, {"a": 30, "b": 39, "jam": "1.07"}, {"a": 30, "b": 38, "jam": "1.31"}, {"a": 30, "b": 37, "jam": "1.20"}, {"a": 30, "b": 40, "jam": "1.18"},{"a": 31, "b": 33, "jam": "1.18"}, {"a": 31, "b": 32, "jam": "1.86"}, {"a": 31, "b": 34, "jam": "1.56"}, {"a": 31, "b": 35, "jam": "1.38"}, {"a": 31, "b": 37, "jam": "1.37"},{"a": 31, "b": 36, "jam": "1.09"}, {"a": 31, "b": 38, "jam": "1.22"}, {"a": 31, "b": 40, "jam": "1.84"}, {"a": 31, "b": 39, "jam": "1.77"}, {"a": 32, "b": 33, "jam": "1.37"},{"a": 32, "b": 34, "jam": "1.60"}, {"a": 32, "b": 35, "jam": "1.01"}, {"a": 32, "b": 36, "jam": "1.44"}, {"a": 32, "b": 38, "jam": "1.76"}, {"a": 32, "b": 39, "jam": "1.39"},{"a": 32, "b": 37, "jam": "1.50"}, {"a": 32, "b": 40, "jam": "1.48"}, {"a": 33, "b": 34, "jam": "1.19"}, {"a": 33, "b": 36, "jam": "1.18"}, {"a": 33, "b": 35, "jam": "1.98"},{"a": 33, "b": 37, "jam": "1.87"}, {"a": 33, "b": 40, "jam": "1.17"}, {"a": 33, "b": 39, "jam": "1.19"}, {"a": 33, "b": 38, "jam": "1.74"}, {"a": 34, "b": 35, "jam": "1.65"},{"a": 34, "b": 37, "jam": "1.26"}, {"a": 34, "b": 38, "jam": "1.93"}, {"a": 34, "b": 39, "jam": "1.33"}, {"a": 34, "b": 40, "jam": "1.05"}, {"a": 34, "b": 36, "jam": "1.98"},{"a": 35, "b": 38, "jam": "1.15"}, {"a": 35, "b": 36, "jam": "1.60"}, {"a": 35, "b": 37, "jam": "1.32"}, {"a": 35, "b": 39, "jam": "1.32"}, {"a": 35, "b": 40, "jam": "1.79"},{"a": 36, "b": 38, "jam": "1.73"}, {"a": 36, "b": 37, "jam": "1.89"}, {"a": 36, "b": 39, "jam": "1.70"}, {"a": 36, "b": 40, "jam": "1.60"}, {"a": 37, "b": 40, "jam": "1.94"},{"a": 37, "b": 38, "jam": "1.53"}, {"a": 37, "b": 39, "jam": "1.29"}, {"a": 38, "b": 40, "jam": "1.81"}, {"a": 38, "b": 39, "jam": "1.38"}, {"a": 39, "b": 40, "jam": "1.31"}
//        ] }
public class TrafficServer {
    public List<OneTrafficServer> traffic;

    public double[][] getArray() {
        double[][] vert = new double[traffic.size()][traffic.size()];
        for (OneTrafficServer route : traffic) {
            vert[route.a][route.b] = route.jam;
            vert[route.b][route.a] = route.jam;
        }
        return vert;
    }
}
