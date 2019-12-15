/**
 */
package org.sheepy.lily.vulkan.model.binding;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Index Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.binding.IndexConfiguration#getIndexCount <em>Index Count</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.binding.BindingPackage#getIndexConfiguration()
 * @model
 * @generated
 */
public interface IndexConfiguration extends IContextConfiguration
{
	/**
	 * Returns the value of the '<em><b>Index Count</b></em>' attribute.
	 * The default value is <code>"2"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index Count</em>' attribute.
	 * @see #setIndexCount(int)
	 * @see org.sheepy.lily.vulkan.model.binding.BindingPackage#getIndexConfiguration_IndexCount()
	 * @model default="2" required="true"
	 * @generated
	 */
	int getIndexCount();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.binding.IndexConfiguration#getIndexCount <em>Index Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index Count</em>' attribute.
	 * @see #getIndexCount()
	 * @generated
	 */
	void setIndexCount(int value);

} // IndexConfiguration
