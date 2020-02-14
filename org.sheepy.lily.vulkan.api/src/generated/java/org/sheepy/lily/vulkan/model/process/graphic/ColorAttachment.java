/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

import org.eclipse.emf.common.util.EList;
import org.joml.Vector4fc;
import org.sheepy.vulkan.model.enumeration.EImageUsage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Color Attachment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.ColorAttachment#getClearValue <em>Clear Value</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.ColorAttachment#getUsages <em>Usages</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getColorAttachment()
 * @model
 * @generated
 */
public interface ColorAttachment extends ExtraAttachment
{
	/**
	 * Returns the value of the '<em><b>Clear Value</b></em>' attribute.
	 * The default value is <code>"0;0;0;0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clear Value</em>' attribute.
	 * @see #setClearValue(Vector4fc)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getColorAttachment_ClearValue()
	 * @model default="0;0;0;0" unique="false" dataType="org.sheepy.lily.core.model.types.Color4f"
	 * @generated
	 */
	Vector4fc getClearValue();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.ColorAttachment#getClearValue <em>Clear Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clear Value</em>' attribute.
	 * @see #getClearValue()
	 * @generated
	 */
	void setClearValue(Vector4fc value);

	/**
	 * Returns the value of the '<em><b>Usages</b></em>' attribute list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.enumeration.EImageUsage}.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EImageUsage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Usages</em>' attribute list.
	 * @see org.sheepy.vulkan.model.enumeration.EImageUsage
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getColorAttachment_Usages()
	 * @model
	 * @generated
	 */
	EList<EImageUsage> getUsages();

} // ColorAttachment
