import pytest


@pytest.mark.parametrize("earned, spent, expected", [(30, 10, 20),(20, 2, 18), ])

def test_transaction(wallet_amount, earned, spent, expected):
    # Add money to wallet
    wallet_amount += earned

    # Substract spent monet from wallet
    wallet_amount -= spent

    
    assert wallet_amount == expected