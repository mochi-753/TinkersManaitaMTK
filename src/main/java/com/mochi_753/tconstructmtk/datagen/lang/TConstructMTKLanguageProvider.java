package com.mochi_753.tconstructmtk.datagen.lang;

import com.mochi_753.tconstructmtk.TConstructMTK;
import com.mochi_753.tconstructmtk.common.registry.TConstructMTKFluids;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.Objects;

public class TConstructMTKLanguageProvider extends LanguageProvider {
    private final String locale;

    public TConstructMTKLanguageProvider(PackOutput output, String locale) {
        super(output, TConstructMTK.MOD_ID, locale);
        this.locale = locale;
    }

    @Override
    protected void addTranslations() {
        switch (this.locale) {
            case "en_us" -> addEnglishTranslations();
            case "ja_jp" -> addJapaneseTranslations();
        }
    }

    private void addEnglishTranslations() {
        add(Objects.requireNonNull(TConstructMTKFluids.MOLTEN_MTK.getBucket()), "Molten MTK Bucket");

        add("fluid.tconstructmtk.molten_mtk", "Molten MTK");

        add("material.tconstructmtk.mtk", "Manaita");

        add("modifier.tconstructmtk.mtk", "MTK");
        add("modifier.tconstructmtk.mtk.flavor", "Manaita POWEERRRR!!!");
        add("modifier.tconstructmtk.mtk.description", "The might of the Manaita resides within you — the ultimate, invincible modifier.");

        add("modifier.tconstructmtk.mtk_unbreakable", "Unbreakable");
        add("modifier.tconstructmtk.mtk_unbreakable.flavor", "Manaita POWEERRRR!!!");
        add("modifier.tconstructmtk.mtk_unbreakable.description", "You really think Manaita’s gonna break?");

        add("stat.tconstruct.harvest_tier.tconstructmtk.mtk", "Manaita");
    }

    private void addJapaneseTranslations() {
        add(Objects.requireNonNull(TConstructMTKFluids.MOLTEN_MTK.getBucket()), "溶融したMTK入りバケツ");

        add("fluid.tconstructmtk.molten_mtk", "溶融したMTK");

        add("material.tconstructmtk.mtk", "まな板");

        add("modifier.tconstructmtk.mtk", "MTK");
        add("modifier.tconstructmtk.mtk.flavor", "かなりまな板だよコレ！");
        add("modifier.tconstructmtk.mtk.description", "まな板の力がその身に宿る... 最強無敵のモディファイア！");

        add("modifier.tconstructmtk.mtk_unbreakable", "不可壊");
        add("modifier.tconstructmtk.mtk_unbreakable.flavor", "かなりまな板だよコレ！");
        add("modifier.tconstructmtk.mtk_unbreakable.description", "まな板が壊れるとでも？");

        add("stat.tconstruct.harvest_tier.tconstructmtk.mtk", "まな板");
    }
}
