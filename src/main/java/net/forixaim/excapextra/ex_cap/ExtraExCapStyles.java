package net.forixaim.excapextra.ex_cap;

import yesman.epicfight.world.capabilities.item.Style;

public enum ExtraExCapStyles implements Style {
    TRIDENT_SHIELD(true),
    DUAL_TRIDENT(true);

    final boolean offhand;
    final int id;
    ExtraExCapStyles(boolean offhand)
    {
        this.offhand = offhand;
        id = Style.ENUM_MANAGER.assign(this);
    }
    @Override
    public boolean canUseOffhand() {
        return false;
    }

    @Override
    public int universalOrdinal() {
        return 0;
    }
}
