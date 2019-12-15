/**
 */
package org.sheepy.lily.vulkan.model.resource;

import org.sheepy.lily.core.model.types.LNamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Part Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.CompositePartReference#getPart <em>Part</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.CompositePartReference#getInstance <em>Instance</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getCompositePartReference()
 * @model
 * @generated
 */
public interface CompositePartReference extends LNamedElement
{
	/**
	 * Returns the value of the '<em><b>Part</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part</em>' attribute.
	 * @see #setPart(int)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getCompositePartReference_Part()
	 * @model unique="false"
	 * @generated
	 */
	int getPart();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.CompositePartReference#getPart <em>Part</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Part</em>' attribute.
	 * @see #getPart()
	 * @generated
	 */
	void setPart(int value);

	/**
	 * Returns the value of the '<em><b>Instance</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance</em>' attribute.
	 * @see #setInstance(int)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getCompositePartReference_Instance()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getInstance();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.CompositePartReference#getInstance <em>Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance</em>' attribute.
	 * @see #getInstance()
	 * @generated
	 */
	void setInstance(int value);

} // CompositePartReference
