import a1
import unittest


class TestSwapK(unittest.TestCase):
    """ Test class for function a1.swap_k. """

    # Add your test methods for a1.swap_k here.
    def test_swap_k_case1(self):
        """Test swap_k where L is an empty list and k is 0. """

        nums = []
        a1.swap_k(nums, 0)
        expected = []
        
        self.assertEqual(nums, expected)

    def test_swap_k_case2(self):
        """Test swap_k where L is a 1-item list and k is 1. """

        nums = [4]
        a1.swap_k(nums, 1)
        expected = [4]
        
        self.assertEqual(nums, expected)

    def test_swap_k_case3(self):
        """Test swap_k where L is a 2-item list and k is 0. """

        nums = [3, 7]
        a1.swap_k(nums, 0)
        expected = [3, 7]
        
        self.assertEqual(nums, expected)

    def test_swap_k_case4(self):
        """Test swap_k where L is a 2-item list and k is 1. """

        nums = [7, 9]
        a1.swap_k(nums, 1)
        expected = [9, 7]
        
        self.assertEqual(nums, expected)
        
    def test_swap_k_case5(self):
        """Test swap_k where L is a 6-item list and k is 0"""

        nums = [1, 2, 3, 4, 5, 6]
        a1.swap_k(nums, 0)
        expected = [1, 2, 3, 4, 5, 6]
        
        self.assertEqual(nums, expected)
        

    def test_swap_k_case6(self):
        """Test swap_k where L is a 6-item list and k is 2"""

        nums = [1, 2, 3, 4, 5, 6]
        a1.swap_k(nums, 2)
        expected = [5, 6, 3, 4, 1, 2]
        
        self.assertEqual(nums, expected)
        
    def test_swap_k_case7(self):
        """Test swap_k where L is a 6-item list and k is 3"""

        nums = [1, 2, 3, 4, 5, 6]
        a1.swap_k(nums, 3)
        expected = [4, 5, 6, 1, 2, 3]
        
        self.assertEqual(nums, expected)
        

if __name__ == '__main__':
    unittest.main(exit=False)
