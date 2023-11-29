package gti.g55.eventichs_organisation.Domaine.Entités

import android.os.Parcel
import android.os.Parcelable

class Évènement (val code: Int, var nom: String, var dateDebut: String, var dateFin: String, val description: String, var addresse:String, val type: String, val organisation_id: Int): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt()
    ) {
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(code)
        parcel.writeString(nom)
        parcel.writeString(dateDebut)
        parcel.writeString(dateFin)
        parcel.writeString(description)
        parcel.writeString(type)
        parcel.writeInt(organisation_id)
    }

    companion object CREATOR : Parcelable.Creator<Évènement> {
        override fun createFromParcel(parcel: Parcel): Évènement {
            return Évènement(parcel)
        }

        override fun newArray(size: Int): Array<Évènement?> {
            return arrayOfNulls(size)
        }
    }


}