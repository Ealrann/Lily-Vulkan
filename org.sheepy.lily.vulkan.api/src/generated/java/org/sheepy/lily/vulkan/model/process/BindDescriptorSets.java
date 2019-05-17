/**
 */
package org.sheepy.lily.vulkan.model.process;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bind Descriptor Sets</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.BindDescriptorSets#getIndex <em>Index</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getBindDescriptorSets()
 * @model
 * @generated
 */
public interface BindDescriptorSets extends IPipelineTask
{

	/**
	 * Returns the value of the '<em><b>Index</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index</em>' attribute.
	 * @see #setIndex(int)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getBindDescriptorSets_Index()
	 * @model default="0" unique="false"
	 * @generated
	 */
	int getIndex();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.BindDescriptorSets#getIndex <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index</em>' attribute.
	 * @see #getIndex()
	 * @generated
	 */
	void setIndex(int value);
} // BindDescriptorSets
