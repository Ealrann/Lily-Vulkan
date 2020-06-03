/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

import org.sheepy.lily.core.api.model.ILilyEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Physical Surface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.PhysicalSurface#getColorDomain <em>Color Domain</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getPhysicalSurface()
 * @model
 * @extends ILilyEObject
 * @generated
 */
public interface PhysicalSurface extends ILilyEObject
{
	/**
	 * Returns the value of the '<em><b>Color Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Color Domain</em>' containment reference.
	 * @see #setColorDomain(ColorDomain)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getPhysicalSurface_ColorDomain()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ColorDomain getColorDomain();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.PhysicalSurface#getColorDomain <em>Color Domain</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color Domain</em>' containment reference.
	 * @see #getColorDomain()
	 * @generated
	 */
	void setColorDomain(ColorDomain value);

} // PhysicalSurface
